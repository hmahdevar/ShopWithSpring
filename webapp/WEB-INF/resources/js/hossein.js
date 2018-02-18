$('.addToCart').click(function (id) {
    $.ajax(
        {
            url: '/cart/add',
            type: 'POST',
            data: {'productId': this.id,
            "quantity":$("#quantity"+this.id).find(":selected").text()},
            dataType: "html",
            success: function (data) {
                alert(data);
            },
            error : function(e) {
                alert('Error: ' + e);
            }
        }
    );
});
$('.removeAttribute').click(function (id) {

    $("#attributeId"+this.id).remove();
    $.ajax(
        {
            url: '/admin/removeAttribute',
            type: 'POST',
            data: {'attributeId': this.id},
            dataType: "html",
            success: function (data) {

            },
            error : function(e) {
                alert('Error: ' + e);
            }
        }
    );


});