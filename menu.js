$(document).ready(function() {
  $('.icon-menu').click(function() {
    $('.menu').animate({left: '0px'}, 400);
    $('body').animate({left: '285px'}, 400);
  });
  $('.icon-close').click(function() {
    $('.menu').animate({left: '-285px'}, 400);
    $('body').animate({left: '0px'}, 400);
  });
 $('.mzaw li').mouseenter(function() {
   $(this).addClass('opac');
 });
 $('.mzaw li').mouseleave(function() {
   $(this).removeClass('opac');
 });
});
