function postReviewData() {
	document.getElementById("searchResults").innerHTML = "<tr><th>Venue Name</th><th>Venue City</th><th>Slot Price</th><th>Average Rating</th><th></th></tr>";
	var windowLocation = window.location.href;
	var request = $.ajax({
		url:  windowLocation + "/reviewPage",
		type: "POST",
		contentType: 'application/json; charset=utf-8',
		success: function(result) {
			for (var i = 0; i < result.length; i++) {
				var table = document.getElementById("searchResults");
				var row = table.insertRow();
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				var cell6 = row.insertCell(5);

				cell1.innerHTML = result[i].venueName;
				cell2.innerHTML = result[i].venueCity;
				cell3.innerHTML = result[i].slotPrice;
				cell4.innerHTML = result[i].averageRating;

				let btn = document.createElement("button");
				console.log(result[i].venueID);
                   var venueID = result[i].venueID;
                               btn.innerHTML = "PostReview";
                               (function(index){
                                   btn.addEventListener("click", function() {
                                     window.location.href = "review/postReviewPage/"+index;
                                   })
                                 })(venueID)
                cell5.append(btn)

			}
		}
	});

	request.fail(function(jqXHR, textStatus) {
		confirm("Request failed: " + textStatus);
	});
}

function postViewReviewData() {
	document.getElementById("searchResults").innerHTML = "<tr><th>Venue Name</th><th>Title</th><th>Description</th><th>Average Rating</th><th></th></tr>";
	var windowLocation = window.location.href;
	var request = $.ajax({
		url:  windowLocation + "/viewReviewPage",
		type: "POST",
		contentType: 'application/json; charset=utf-8',
		success: function(result) {
			for (var i = 0; i < result.length; i++) {
				var table = document.getElementById("searchResults");
				var row = table.insertRow();
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);

				cell1.innerHTML = result[i].venueName;
				cell2.innerHTML = result[i].reviewTitle;
				cell3.innerHTML = result[i].reviewDescription;
				cell4.innerHTML = result[i].averageRating;

			}
		}
	});

	request.fail(function(jqXHR, textStatus) {
		confirm("Request failed: " + textStatus);
	});
}



