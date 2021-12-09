function postVenueData() {
	document.getElementById("searchResults").innerHTML = "<tr><th>Venue ID</th><th>Venue Name</th><th>Venue City</th><th>Available Slots</th><th>Total Slots</th><th>From Time</th><th>To Time</th><th>Contact Info</th><th>Latitude</th><th>Longitude</th><th>Slot Price</th><th>Average Rating</th><th>Category ID</th><th></th></tr>";
    var sortParam = document.getElementById("sort").value;

	var windowLocation = window.location.href;
	var request = $.ajax({
		url:  windowLocation + "/getVenueResults",
		type: "POST",
		data: sortParam,
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
				var cell7 = row.insertCell(6);
				var cell8 = row.insertCell(7);
				var cell9 = row.insertCell(8);
				var cell10 = row.insertCell(9);
				var cell11 = row.insertCell(10);
				var cell12 = row.insertCell(11);
				var cell13 = row.insertCell(12);
				var cell14 = row.insertCell(13);

				cell1.innerHTML = result[i].venueID;
				cell2.innerHTML = result[i].venueName;
				cell3.innerHTML = result[i].venueCity;
				cell4.innerHTML = result[i].availableSlots;
				cell5.innerHTML = result[i].totalSlots;
				cell6.innerHTML = result[i].fromTime;
				cell7.innerHTML = result[i].toTime;
				cell8.innerHTML = result[i].contactInfo;
				cell9.innerHTML = result[i].latitude;
				cell10.innerHTML = result[i].longitude;
				cell11.innerHTML = result[i].slotPrice;
				cell12.innerHTML = result[i].averageRating;
				cell13.innerHTML = result[i].categoryID;
				let btn = document.createElement("button");
				    var venueid = result[i].venueID;
                    btn.innerHTML = "Book";
                    (function(index){
                        btn.addEventListener("click", function() {
                          window.location.href = "venue/"+index;
                        })
                      })(venueid)
                    cell14.append(btn);
			}
		}
	});

	request.fail(function(jqXHR, textStatus) {
		confirm("Request failed: " + textStatus);
	});
}

function redirect(i) {
      window.location.href = "venue.htm?data="+i
}