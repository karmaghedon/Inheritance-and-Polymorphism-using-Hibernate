<%-- 
    Document   : singleRecord
    Created on : 17-Apr-2019, 12:38:01 AM
    Author     : nicolaenastas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
html>
    <head>
        <title>Weather Application</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>
        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <a class="navbar-brand">Person Data</a>
            <form class="form-inline">
                <input class="form-control ui-autocomplete-input" type="search" autocomplete="off" placeholder="Search" aria-label="Search" id="mySearch">
                <input class="form-control ui-autocomplete-input" type="hidden" autocomplete="off" placeholder="Search" aria-label="Search" id="mySearchTemp">

                <div id='btnSearch'>
                    <a class="btn btn-primary" href="/"  role="button"  id="submitSearch" >Search</a>                                       
                </div>

            </form>
        </nav>

        <table class="table table-hover" id="myTable">
            <thead>
            </thead>
            <tbody>
            </tbody>
        </table>
        <div id="getImg">

        </div>

        <div id='btnAdd'>
        </div>




        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>            
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


        <script>
            $(document).ready(function (ev) {
                var data = "";
                var personSelection = "";
                var id;
                fetch('api/findById/'+id).then(function (response) {

                    return response.clone().json();

                }).then(function (json) {

                    $("#myTable > thead").append(
                            '<tr>' +
                            // '<th>Edit</th>' +
                            '<th scope="col">Name</th>' +
                            '<th scope="col">Address</th>' +
                            '<th scope="col">Phone</th>' +
                            ' <th scope="col">Email</th>' +
                            ' <th scope="col">Options</th>' +
                            //'<th>Delete</th>' +
                            '</tr>');
                    for (i = 0; i < json.length; i++) {
                        var row_id = json[i].id;
                        $("#myTable > tbody").append(
                                '<tr row_id="' + row_id + '">' +
                                '<td ><div class="row_data" edit_type="click" col_name="name">' + json[i].name + '</div></td>' +
                                '<td ><div class="row_data" edit_type="click" col_name="address">' + json[i].address + '</div></td>' +
                                '<td ><div class="row_data" edit_type="click" col_name="phone">' + json[i].phone + '</div></td>' +
                                '<td ><div class="row_data" edit_type="click" col_name="email">' + json[i].email + '</div></td>' +
                                
                                '<td>' +
                                '<span class="btn_edit" > <a href="#" class="btn btn-link " row_id="' + row_id + '" > Edit</a> </span>' +
                                '<span class="btn_delete" > <a href="#" class="btn btn-link " row_id="' + row_id + '" > Delete</a> </span>' +
                                
                                '<span class="btn_save"> <a href="#" class="btn btn-link"  row_id="' + row_id + '"> Save</a> | </span>' +
                                '<span class="btn_cancel"> <a href="#" class="btn btn-link" row_id="' + row_id + '"> Cancel</a> | </span>' +
                                '</td>' +
                                

                                '</tr>'
                                );

                        $(document).find('.btn_save').hide();
                        $(document).find('.btn_cancel').hide();
                    }


//                    $("#btnAdd").append('<a class="btn btn-primary addStd" role="button">Add Student</a>' +
//                            '<a class="btn btn-primary addEmpl" role="button">Add Employee</a>'
//                            );
//                    $(".addStd").bind("click", AddStd);
//                    $(".addEmpl").bind("click", AddEmpl);



                    //--->make div editable > start
                    $(document).on('click', '.row_data', function (event)
                    {
                        event.preventDefault();

                        if ($(this).attr('edit_type') == 'button')
                        {
                            return false;
                        }

                        
                        $(this).closest('div').attr('contenteditable', 'true');
                       
                        $(this).addClass('bg-warning').css('padding', '5px');

                        $(this).focus();
                    })


	
                    $(document).on('click', '.btn_edit', function (event)
                    {
                        event.preventDefault();
                        var tbl_row = $(this).closest('tr');

                        var row_id = tbl_row.attr('row_id');

                        tbl_row.find('.btn_save').show();
                        tbl_row.find('.btn_cancel').show();

                        
                        tbl_row.find('.btn_edit').hide();

                       
                        tbl_row.find('.row_data')
                                .attr('contenteditable', 'true')
                                .attr('edit_type', 'button')
                                .addClass('bg-warning')
                                .css('padding', '3px')

                        
                        tbl_row.find('.row_data').each(function (index, val)
                        {
                            
                            $(this).attr('original_entry', $(this).html());
                        });
                       

                    });

                    $(document).on('click', '.btn_cancel', function (event)
                    {
                        event.preventDefault();
                        
                        var tbl_row = $(this).closest('tr');

                        var row_id = tbl_row.attr('row_id');

                        
                        tbl_row.find('.btn_save').hide();
                        tbl_row.find('.btn_cancel').hide();

                        
                        tbl_row.find('.btn_edit').show();

                        
                        tbl_row.find('.row_data')
                                .attr('edit_type', 'click')
                                .removeClass('bg-warning')
                                .css('padding', '');

                        tbl_row.find('.row_data').each(function (index, val)
                        {
                            $(this).html($(this).attr('original_entry'));
                        });
                    });

                    
                    $(document).on('click', '.btn_save', function (event)
                    {
                        event.preventDefault();
                        var tbl_row = $(this).closest('tr');

                        var row_id = tbl_row.attr('row_id');


                        
                        tbl_row.find('.btn_save').hide();
                        tbl_row.find('.btn_cancel').hide();

                        
                        tbl_row.find('.btn_edit').show();


                        //make the whole row editable
                        tbl_row.find('.row_data')
                                .attr('edit_type', 'click')
                                .removeClass('bg-warning')
                                .css('padding', '')

                        
                        var arr = {};
                        tbl_row.find('.row_data').each(function (index, val)
                        {
                            var col_name = $(this).attr('col_name');
                            var col_val = $(this).html();
                            arr[col_name] = col_val;
                        });
                        

                        
                        $.extend(arr, {row_id: row_id});

                        
                        var jsonString = JSON.stringify(arr, null, 2);
                        
                        var urlToSend = "http://localhost:8080/Inheritance_Polymorphism/api/test/insert/";
                        if(personSelection === "Student"){
                            urlToSend = urlToSend+"Student";
                        }else{
                            urlToSend = urlToSend+"Employee";
                        }
                        $.ajax({
                            url: urlToSend,
                            method: 'POST',
                            data: jsonString,
                            contentType: 'application/json; charset=utf-8',
                            success: function (data) {
                                tbId = data;
                                $("#row_id").value = tbId;
                                alert("Saved Successfully " + tbId);
                            },
                            error: function (error) {
                                alert("Error");
                                alert(error.toString());
                            }


                        });


                    });


                    $(document).on('click', '.btn_delete', function (event)
                    {
                        var tbl_row = $(this).closest('tr');

                        var row_id = tbl_row.attr('row_id');
                        var id = row_id;
                        tbl_row.remove();

                        $.ajax({
                            url: "http://localhost:8080/Inheritance_Polymorphism/api/test/delete/" + id,
                            method: 'DELETE',
                            success: function () {
                                alert("Deleted Successfully");
                            },
                            error: function (error) {
                                alert("Error");
                                alert(error);
                            }
                        });
                    });




                  

                $("#submitSearch").click(function () {
                    data = $('#mySearchTemp').val();
                    var id = Integer.valueOf(data.substring(0, data.indexOf(",")).replace(/\s+/g, ''));
                    var uri = '/singleRecord' + id;
                    $('a[href^="/"]').each(function () {
                        var oldUrl = $(this).attr("href"); // Get current url
                        var newUrl = oldUrl.replace("/", uri); // Create new url

                        $(this).attr("href", newUrl); // Set herf value

                    });

                });



                $(function () {

                    var getData = function (request, response) {

                        $.getJSON(
                                "http://localhost:8080/Inheritance_Polymorphism/api/test/listAllFilter",
                                function (data) {

                                    response(data);

                                });
                    };

                    var selectItem = function (event, ui) {
                        this.value = ui.item.label;
                        $("#mySearchTemp").val(ui.item.value);
                        return false;
                    };

                    $("#mySearch").autocomplete({                        
                        source: getData,
                        select: selectItem,
                        minLength: 1,
                        change: function () {
                            $("#mySearch").val("").css("display", 2);
                        }

                    });
                });


            });







        </script>


        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>




    </body>

</html>



