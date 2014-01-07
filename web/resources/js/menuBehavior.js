$(document).ready(function() {
    $('a.has-btn').click(function() {        
        var nextUl = $(this).next('.secondary');
        if ($(nextUl).is(':visible')) {
            //$(nextUl).hide();
            $(nextUl).slideUp('normal');
            $(this).removeClass('active');
        } else {
            //$(nextUl).show();
            $(nextUl).slideDown('normal');
            $(this).addClass('active');
        }
    });
    
});
