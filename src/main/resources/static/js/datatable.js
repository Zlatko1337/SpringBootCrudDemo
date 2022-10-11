
$(document).ready( function () {
		
	var datatable = $('#bandsTable').DataTable({
		"processing": true,
	    "serverSide": true,
	    "pageLength": 10,
	    "searching": false,
	    "info" : true,
		"ajax": {
	        "url": "/bands",
	        "method":"get",
	        "dataSrc": function (response) {
	            var data = response.data;
	            var all = [];
	            for (var i = 0; i < data.length; i++) {
	                var row = {
	                    rows: response.start + i + 1,
	                    id: data[i].id,
	                    name: data[i].name,
	                    yearFormed: data[i].yearFormed,  
	                    musicians: data[i].musicians,
	                    albums: data[i].albums    
	                };
	                all.push(row);
	            }
	            return all;
        	}
        },
		"columns":	[	
						{
			                "className":      'details-control',
			                "orderable":      false,
			                "data":           null,
			                "defaultContent": ''
						},
		    			{ "className": 'dt-center', "data": "id"},
		  				{ "data": "name" },
			  			{ "className": 'dt-center', "data": "yearFormed" },
			  			{
            				"targets": "-2",
            				"data": null,
            				"defaultContent": ""
        				},
			  			{
            				"targets": "-1",
            				"data": null,
            				"defaultContent": "<button class='btn btn-primary deleteBtn'>Delete</button>"
        				}
					],
		"fnCreatedRow": function(row, data, dataIndex) {
        	$('td:eq(4)', row).append("<a href='/bands/edit/"+data.id+"' class='btn btn-primary'>Edit</a></td>");
        }
	});
	 
	$('#bandsTable tbody').on('click', 'td.details-control', function () {
		var tr = $(this).closest('tr');
		var row = datatable.row(tr);
	 
		if (row.child.isShown()) {
		    row.child.hide();
		    tr.removeClass('shown');
		}
		else {
		    row.child(format(row.data())).show();
		    tr.addClass('shown');
		}
	}); 
	
	
	$('#bandsTable tbody').on('click', 'button', function() {	
    	var data = datatable.row($(this).parents('tr')).data();
        
        if ($(this).hasClass('deleteBtn')){
			$.ajax({
				url: "/bands/"+data.id,
				type: "DELETE",
				success: function(result) {
					datatable.ajax.reload();
//					datatable.clear();
//         			datatable.rows.add(result);
//          		datatable.draw();
				}
			}); 
		} 
         
    });
	
});


function format(d) {
	var table = '<table><tr><th colspan="3">Musicians</th></tr><tr><th>Id</th><th>Name</th><th>Birthdate</th></tr>';
	$.each(d.musicians, function(i, e) {
        table+='<tr><td>'+e.id+'</td>'+'<td>'+e.name+'</td>'+'<td>'+e.dateOfBirth+'</td></tr>';      
        if (i === d.musicians.length-1) { table+='</table>'}   
    });
	
	table+='<table><tr><th colspan="3">Albums</th></tr><tr><th>Id</th><th>Name</th><th>Year Released</th></tr>';
	
	$.each(d.albums, function(i, e) {
        table+='<tr><td>'+e.id+'</td>'+'<td>'+e.name+'</td>'+'<td>'+e.yearReleased+'</td><td><a href="/songs?albumId='+e.id+'" class="btn btn-primary">View</a></td></tr>';      
        if (i === d.albums.length-1) { table+='</table>' }   
    });
    
	return table;
}