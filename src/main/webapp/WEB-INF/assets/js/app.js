
$(".heightline-post").heightLine({
        fontSizeCheck: true
});

$(document).ready(function() {
	console.log("ready")
	var table = $('#data-table').DataTable({
		"paging": true,
		"pageLength": 5,
		"bLengthChange": false,
		"bFilter": true,
		"bInfo": false,
		"bAutoWidth": false,
		"dom": 'rtp',
		"scrollX": false,
       "responsive": true
	});
$('#dataTableSearch').keyup(function() {
		table.search($(this).val()).draw();
		userTable.search($(this).val()).draw();
	});
});