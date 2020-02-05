var openList = {

	dataTable : null, //리스트
    
    /* 초기 로딩시 실행 */
    init : function() {
        console.log('Loading openList List Data...');
        this.dataTableRender();
    },

	dataTableRender: function(){
	    
		var user_id = $("#userName").text();
		
	    $.ajax({
	        url: '/visionmeet/selectVideo',
	        type : 'post',
	        data : {user_id : user_id},
	        dataType: 'json',
	        success: function(data) {
	            if (data.result) {
	            	openList.makeDataTable(data);
	                
	            }
	        },
	        error: function(ee)
	        {
	            console.log(ee);
	        }
	    });
	}, 

	makeDataTable : function(data) {
	    
	    $dataTable = $("#dataTable");
	    
	    var length = Object.keys(data.list).length;
	    
	    for(var i = 0; i < length; i++) {
	      var List = data.list[i];
	      
	      $dataTable.dataTable().fnAddData( [
	    	  List.idx,
	    	  List.company_code,
	    	  List.room_id,
	    	  List.master_id,
	    	  List.customer_id,
	    	  List.create_datetime,
	    	  List.end_datetime,
	    	  List.master_join_datetime,
	    	  List.master_leave_datetime,
	    	  List.client_join_datetime,
	    	  List.client_leave_datetime
	      ]);
	
	    }
	    
	    //$("#userName").text(data.userName);
	}
}