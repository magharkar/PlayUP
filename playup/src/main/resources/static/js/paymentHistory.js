function getPaymentHistory() {
    document.getElementById("history").innerHTML = "<tr><th>Transaction Id</th><th>Name</th><th>Amount</th><th>Time Stamp</th></tr>";
    var sortParam = document.getElementById("history").value;
    var request = $.ajax({
        type: "POST",
        data: sortParam,
        contentType: 'application/json; charset=utf-8',
        success: function(result) {
            for (var i = 0; i < result.length; i++) {
                var table = document.getElementById("history");
                var row = table.insertRow();
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                cell1.innerHTML = result[i].transactionId;
                cell2.innerHTML = result[i].name;
                cell3.innerHTML = result[i].amount;
                cell4.innerHTML = result[i].timeStamp;
            }
        }
    });
    request.fail(function(jqXHR, textStatus) {
        confirm("Request failed: " + textStatus);
    });
}