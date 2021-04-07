const mealAjaxUrl = "profile/meals";

// https://stackoverflow.com/a/5064235/548473
const ctx = {
    ajaxUrl: mealAjaxUrl
};

// $(document).ready(function () {
$(function () {
    makeEditable(
        $("#datatable").DataTable({
            "paging": false,
            "info": true,
            "filter":false,
            "columns": [
                {
                    "data": "dateTime"
                },
                {
                    "data": "description"
                },
                {
                    "data": "calories"
                },
                {
                    "defaultContent": "Edit",
                    "orderable": false
                },
                {
                    "defaultContent": "Delete",
                    "orderable": false
                }
            ],
            "order": [
                [
                    0,
                    "desc"
                ]
            ]
        })
    );
});

function filter() {
    const form = $("#filterForm");
    $.ajax({
        type: "GET",
        url: /*ctx.ajaxUrl + */"profile/meals/filter",
        data: form.serialize()
    }).done(function (data) {
        ctx.datatableApi.clear().rows.add(data).draw();
    });
}