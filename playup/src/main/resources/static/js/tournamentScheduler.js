function postData() {
	var errordiv = document.getElementById('error-info');
	var typeoftournament = document.getElementById("tournament").value;
	var sportname = document.getElementById("sports").value;
	var playernumber = document.getElementById("numberOfplayers").value;
	errordiv.innerHTML = "";
	var request = $.ajax({
		url: "http://localhost:8080/tournamentScheduler/getMatchSchedule",
		type: "POST",
		contentType: 'application/json; charset=utf-8',
		data: JSON.stringify({
			'tournamentType': typeoftournament,
			'playersPerTeam': playernumber,
			'tournamentSport': sportname
		}),
		success: function(result) {
			if (result[1] == null) {
				document.getElementById('tournament').disabled = true;
				document.getElementById('sports').disabled = true;
				document.getElementById('numberOfplayers').disabled = true;
				document.getElementById('fsubmit').disabled = true;

				for (var i = 0; i < result[0].matchesList.length; i++) {
					var table = document.getElementById("tournamentTable");
					var row = table.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);

					if (result[0].matchesList[i].teamOne == null) {
						if (result[0].matchesList[i].teamTwo == null) {
							continue;
						}
						cell2.innerHTML = "Team A(" + result[0].matchesList[i].teamOne.teamNumber + ") goes to next round";
					} else if (result[0].matchesList[i].teamTwo == null) {
						cell2.innerHTML = "Team A(" + result[0].matchesList[i].teamOne.teamNumber + ") goes to next round";
					} else {
						cell2.innerHTML = "Team A (" + result[0].matchesList[i].teamOne.teamNumber + ") Vs Team B (" + result[0].matchesList[i].teamTwo.teamNumber + ")";
					}
					cell1.innerHTML = i + 1;
					cell3.innerHTML = result[0].matchesList[i].matchDate;
				}
			}
			else {
				errordiv.innerHTML = "<p style='color:red'>" + result[1] + "</p>";
			}
		}
	});

	request.fail(function(jqXHR, textStatus) {
		confirm("Request failed: " + textStatus);
	});
}