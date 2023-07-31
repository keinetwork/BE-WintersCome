let publicIp;

let accesscountObj = {
	init: function() {
		$.ajax({
			type: 'GET',
			url: 'https://api64.ipify.org/?format=json',
			async: false,
			success: function(data){
				publicIp=data.ip;
			}
		});
		$.ajax({
			type: 'POST',
			url: '/AccessCount',
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				ipAddr: publicIp
			}),
			async: false,
			success: function(data){				
				console.log("accesscount: %o", data);
				document.write("accesscount<br>"+JSON.stringify(data)+"<br><br>");
			},
			error : function(request, status, error) {
			    console.log(error);
			}
		});
	}
}

accesscountObj.init();