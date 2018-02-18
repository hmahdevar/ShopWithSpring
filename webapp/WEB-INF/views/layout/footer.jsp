<!-- Bootstrap core and JavaScript's
================================================== -->
<script src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.parallax.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.fitvids.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.unveilEffects.js"/>"></script>
<script src="<c:url value="/resources/js/retina-1.1.0.js"/>"></script>
<script src="<c:url value="/resources/js/fhmm.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-select.js"/>"></script>
<script src="<c:url value="/resources/fancyBox/jquery.fancybox.pack.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-fileupload.js"/>"></script>
<script src="<c:url value="/resources/js/application.js"/>"></script>
<script src="<c:url value="/resources/js/hossein.js"/>"></script>

<!-- FlexSlider JavaScript
================================================== -->
<script src="<c:url value="/resources/js/jquery.flexslider.js"/>"></script>
<script>
    $(window).load(function () {
        $('#carousel').flexslider({
            animation: "slide",
            controlNav: false,
            directionNav: false,
            animationLoop: true,
            slideshow: true,
            itemWidth: 122,
            itemMargin: 0,
            asNavFor: '#slider'
        });

        $('#slider').flexslider({
            animation: "fade",
            controlNav: false,
            animationLoop: false,
            slideshow: true,
            sync: "#carousel"
        });
    });
</script>

<script type="text/javascript">

    var locations = [
        ['<div class="infobox agents_widget"><div class="agent clearfix"><div class="image"><img class="img-thumbnail img-responsive" src="demos/01_home.jpg" alt=""></div><div class="agent_desc"><h3 class="title"><a href="single-property.html">Home of your dreams</a></h3><span>890 Istanbul / Maslak</span></p></div></div></div>', -33.950198, 151.259302, 1]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 10,
        scrollwheel: false,
        navigationControl: true,
        mapTypeControl: false,
        scaleControl: false,
        draggable: true,
        styles: [{"stylers": [{"hue": "#19B8DF"}, {"gamma": 1}]}],
        center: new google.maps.LatLng(-33.92, 151.25),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {

        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map,
            icon: 'images/marker.png'
        });


        google.maps.event.addListener(marker, 'click', (function (marker, i) {
            return function () {
                infowindow.setContent(locations[i][0]);
                infowindow.open(map, marker);
            }
        })(marker, i));
    }
</script>
</body>
</html>