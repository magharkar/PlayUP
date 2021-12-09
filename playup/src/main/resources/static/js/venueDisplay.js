function postVenueData() {
	document.getElementById("searchResults").innerHTML = "<tr><th>Venue Name</th><th>Venue City</th><th>Available Slots</th><th>Total Slots</th><th>Contact Info</th><th>Slot Price</th><th>Average Rating</th><th></th></tr>";
	var sortParam = document.getElementById("sort").value;
	var windowLocation = window.location.href;
	var request = $.ajax({
		url: windowLocation + "/getVenueResults",
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

				cell1.innerHTML = result[i].venueName;
				cell2.innerHTML = result[i].venueCity;
				cell3.innerHTML = result[i].availableSlots;
				cell4.innerHTML = result[i].totalSlots;
				cell5.innerHTML = result[i].contactInfo;
				cell6.innerHTML = result[i].slotPrice;
				cell7.innerHTML = result[i].averageRating;
				let btn = document.createElement("button");
				    var venueid = result[i].venueID;
                    btn.innerHTML = "Book";
                    (function(index){
                        btn.addEventListener("click", function() {
                          window.location.href = "venue/"+index;
                        })
                      })(venueid)
                    cell8.append(btn);
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