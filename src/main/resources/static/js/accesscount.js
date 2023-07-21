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
		let body= {
				ipAddr: publicIp
		}
		$.ajax({
			type: 'POST',
			url: 'http://127.0.0.1:8080/AccessCount',
			data: JSON.stringify(body),
			contentType: "application/json; charset=utf-8",
			async: false,
			success: function(data){				
				console.log("accesscount: %o", data);
				document.write("accesscount<br>"+JSON.stringify(data)+"<br><br>");
			}
		});
	}
}

accesscountObj.init();