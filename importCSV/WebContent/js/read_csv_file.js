$(document).ready(function () {
	$('#uploadFile').on("click", function (e) {
		e.preventDefault();
		$('#csvFile').parse({
			config: {
				delimiter: "auto",
				complete: renderCSVData,
			},
			before: function (file, inputElem) {
				console.log("Parsing file...", file);
			},
			error: function (err, file) {
				console.log("ERROR:", err, file);
			},
			complete: function () {
				console.log("Done with all files");
			}
		});
	});
});

function renderCSVData(resultsData) {

	var tableHTML = "<table class='table table-striped table-bordered table-hover'>";
	var results = resultsData.data;

	tableHTML += "<tr>";

	c = results[0].join(",").split(",")
	for (let index = 0; index < c.length; index++) {

		tableHTML += "<td><select class='form-control' name='option" + index + "'>";
		tableHTML += "<option >Select Option</option>";
		tableHTML += "<option value='menuitem code'>Menuitem Code</option>";
		tableHTML += "<option value='name'>Name</option>";
		tableHTML += "<option value='description'>Description</option>";
		tableHTML += "<option value='available time'>Available Time</option>";
		tableHTML += "<option value='delivery time'>Delivery Time</option>";
		tableHTML += "<option value='keywords'>Keywords</option>";
		tableHTML += "<option value='image'>Image</option>";
		tableHTML += "<option value='position'>Position</option>";
		tableHTML += "<option value='price'>Price</option><";
		tableHTML += "option value='hotel id'>Hotel Id</option>";
		tableHTML += "</select></td>";

	}

	tableHTML += "</tr>";

	for (i = 0; i < results.length; i++) {
		tableHTML += "<tr>";
		var row = results[i];
		var cells = row.join(",").split(",");
		for (j = 0; j < cells.length; j++) {
			tableHTML += "<td>";
			tableHTML += cells[j];
			tableHTML += "</td>";
		}
		tableHTML += "</tr>";
	}
	tableHTML += "</table>";


	if (results.length > 0) {
		tableHTML += "<button type='submit' id='uploadFile' class='btn btn-primary center-block'>Next</button>"
	}


	$("#dataList").html(tableHTML);
}