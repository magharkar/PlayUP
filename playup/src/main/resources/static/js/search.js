function postData() {
	document.getElementById("searchResults").innerHTML = "<tr><th>Venue Name</th><th>Venue City</th><th>Available Slots</th><th>Total Slots</th><th>Contact Info</th><th>Slot Price</th><th>Average Rating</th><th></th></tr>";
	var searchKey = document.getElementById("searchKey").value;
	var windowLocation = window.location.href;
	var request = $.ajax({
		url: windowLocation + "/getSearchResults",
		type: "POST",
		contentType: 'application/json; charset=utf-8',
		data: searchKey,
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

				cell1.innerHTML = result[i].venueName;
				cell2.innerHTML = result[i].venueCity;
				cell3.innerHTML = result[i].availableSlots;
				cell4.innerHTML = result[i].totalSlots;
				cell5.innerHTML = result[i].cotactInfo;
				cell6.innerHTML = result[i].slotPrice;
				cell7.innerHTML = result[i].averageRating;
				cell14.innerHTML = "<input type='button' id='book' name='book' onClick= '' value='book' />";

			}
		}
	});

	request.fail(function(jqXHR, textStatus) {
		confirm("Request failed: " + textStatus);
	});

}