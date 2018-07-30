function initMap() {
    var map_icon_1_location = {lat: 40.694835, lng: -73.918290};
    var map_icon_1_pin_icon = {
        url: 'img/pin_icon_red.svg',
        anchor: new google.maps.Point(0, 0),
        strokeWeight: 0,
        scaledSize: new google.maps.Size(75, 75)
    };
    var map_icon_2_location = {lat: 40.680577, lng: -73.803513};
    var map_icon_2_pin_icon = {
        url: 'img/pin_icon_green.svg',
        anchor: new google.maps.Point(25, 50),
        strokeWeight: 0,
        scaledSize: new google.maps.Size(75, 75)
    };
    var map = new google.maps.Map(document.getElementById('bsm_map'), {
        zoom: 13,
        center: {lat: 40.688869, lng: -73.865633}
    });
    var marker_1 = new google.maps.Marker({
        position: map_icon_1_location,
        map: map,
        title: 'Hello World!',
        icon: map_icon_1_pin_icon
    });
    var marker_2 = new google.maps.Marker({
        position: map_icon_2_location,
        map: map,
        title: 'Hello World!',
        icon: map_icon_2_pin_icon
    });
}
(function ($) {
    "use strict";
    jQuery(document).ready(function () {
        if ($(window).width() > 767) {
            var homeSwiper = new Swiper('.swiper-container', {
                pagination: '.swiper-pagination',
                paginationClickable: true,
                direction: 'vertical',
                loop: true,
                autoplay: false,
                speed: 2000,
                effect: 'slide'
            });
        } else {
            var homeSwiper = new Swiper('.swiper-container', {
                pagination: '.swiper-pagination',
                paginationClickable: true,
                direction: 'horizontal',
                loop: true,
                autoplay: false,
                speed: 2000,
                effect: 'slide'
            });
        }
        var swiper = new Swiper('.bsm_product_page_carousel', {
            pagination: '.swiper-pagination',
            slidesPerView: 4,
            direction: 'horizontal',
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',
            breakpoints: {
                991: {
                    slidesPerView: 4
                },
                767: {
                    slidesPerView: 4
                },
                480: {
                    slidesPerView: 4
                }
            }
        });
        var galleryTop = new Swiper('#bsm_product_page_carousel_principal', {
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',
            direction: 'horizontal'
        });
        var galleryThumbs = new Swiper('#bsm_product_page_carousel_secundary', {
            spaceBetween: 10,
            centeredSlides: true,
            direction: 'horizontal',
            slidesPerView: 'auto',
            slideToClickedSlide: true
        });
        galleryTop.params.control = galleryThumbs;
        galleryThumbs.params.control = galleryTop;

        var bsm_s6 = $('#bsm_section_6');
        var bsm_s6_a = $('#bsm_section_6 a');
        var bsm_s6_count = 8;
        var bsm_s6_size = $('#bsm_section_6 .bsm_section_6_content').size();
        $('#bsm_section_6 .bsm_section_6_content:lt(' + bsm_s6_count + ')').show();
        bsm_s6_a.on('click', function () {
            bsm_s6_count = (bsm_s6_count + 4 <= bsm_s6_size) ? bsm_s6_count + 4 : bsm_s6_size;
            $('#bsm_section_6 .bsm_section_6_content:lt(' + bsm_s6_count + ')').slideDown();
            if (bsm_s6_count === bsm_s6_size) {
                $(this).fadeOut();
                bsm_s6.css({
                    'margin-bottom': '140px'
                });
            }
        });

        var bsm_menu_s2 = $("#bsm_section_2_menu_content");
        var bsm_menu_s2_content = $("#bsm_section_2_menu_content .col-md-6");
        var bsm_menu_s2_size = bsm_menu_s2_content.size();
        var bsm_menu_s2_count = 10;
        var bsm_menu_s2_load = $('#bsm_section_2_menu_product_load_more');
        $('#bsm_section_2_menu_content .col-md-6:lt(' + bsm_menu_s2_count + ')').show();
        $('#bsm_section_2_menu_content .col-md-6:lt(' + (bsm_menu_s2_count - 2) + ')').addClass('active');
        bsm_menu_s2_load.on('click', function () {
            bsm_menu_s2_count = (bsm_menu_s2_count + 4 <= bsm_menu_s2_size) ? bsm_menu_s2_count + 4 : bsm_menu_s2_size;
            $('#bsm_section_2_menu_content .col-md-6:lt(' + bsm_menu_s2_count + ')').slideDown();
            $('#bsm_section_2_menu_content .col-md-6:lt(' + (bsm_menu_s2_count - 2) + ')').addClass('active');
            if (bsm_menu_s2_count === bsm_menu_s2_size) {
                $(this).fadeOut();
                bsm_menu_s2.css({
                    'padding-bottom': '50px'
                });
            }
        });

        var bsm_s5_span = $('#bsm_section_5 .bsm_section_5_content_text span');
        var bsm_s5_img_normal = $('.bsm_section_5_content_image_normal');
        var bsm_s5_img_hover = $('.bsm_section_5_content_image_hover');
        bsm_s5_span.hover(function () {
            $(this).parent().find('h1').css({
                'color': '#cf3045'
            });
            $(this).parent().parent().last().find('svg').css({
                'fill': '#cf3045'
            });
            $(this).parent().parent().last().find(bsm_s5_img_normal).hide();
            $(this).parent().parent().last().find(bsm_s5_img_hover).show();
        });
        bsm_s5_span.on('mouseleave', function () {
            $(this).parent().find('h1').css({
                'color': '#ffffff'
            });
            $(this).parent().parent().last().find('svg').css({
                'fill': '#BBB7B3'
            });
            $(this).parent().parent().last().find(bsm_s5_img_normal).show();
            $(this).parent().parent().last().find(bsm_s5_img_hover).hide();
        });

        var bsm_s2_svg = $('#bsm_section_2 svg');
        var bsm_s2_content = $('#bsm_section_2 .bsm_section_2_content');
        var bsm_s2_content_h1 = $('#bsm_section_2 .bsm_section_2_content h1');
        var bsm_s2_img_content = $('.bsm_section_2_content_image_content');
        var bsm_s2_img_content_img = $('.bsm_section_2_content_image_content img');
        var bsm_s2_content_svg = $('#bsm_section_2 .bsm_section_2_content svg');
        var bsm_s2_img_content_svg = $('.bsm_section_2_content_image_content svg');
        bsm_s2_content.hover(function () {
            var bsm_section_2_image_source = $(this).find('img').attr('src');
            bsm_s2_img_content_img.attr('src', bsm_section_2_image_source);
            bsm_s2_content_h1.removeClass('bsm_color_green');
            bsm_s2_content_h1.addClass('bsm_color_red ');
            $(this).find('h1').addClass('bsm_color_green');
            bsm_s2_content_svg.css({
                'fill': '#cf3045'
            });
            $(this).find('svg').css({
                'fill': '#20b247'
            });
        });
        bsm_s2_content.on('mouseleave', function () {
            var bsm_section_2_image_source_default = $(bsm_s2_img_content).parent().parent().find('img').attr('src');
            bsm_s2_img_content_img.attr('src', bsm_section_2_image_source_default);
            bsm_s2_content_h1.removeClass('bsm_color_green');
            bsm_s2_content_h1.addClass('bsm_color_red ');
            bsm_s2_img_content.parent().parent().find('h1').addClass('bsm_color_green');
            bsm_s2_svg.css({
                'fill': '#cf3045'
            });
            bsm_s2_img_content_svg.find('svg').css({
                'fill': '#20b247'
            });
        });

        var bsm_s3_content = $('#bsm_section_3 .bsm_section_3_content');
        var bsm_s3_img = $('#bsm_section_3 .bsm_section_3_image');
        bsm_s3_content.hover(function () {
            if ($(this).hasClass('bsm_section_3_content_second')) {
                $(this).prev().children().children().addClass('bsm_section_3_image_overlay_active');
            } else if ($(this).hasClass('bsm_section_3_content_first')) {
                $(this).next().children().children().addClass('bsm_section_3_image_overlay_active');
            }
        });
        bsm_s3_content.on('mouseleave', function () {
            bsm_s3_img.removeClass('bsm_section_3_image_overlay_active');
        });

        var bsm_about_s2_text = $('#bsm_section_2 .bsm_section_2_about_page_content_text');
        var bsm_about_s2_img = $('#bsm_section_2 .bsm_section_2_about_page_content_image');
        bsm_about_s2_text.hover(function () {
            bsm_about_s2_img.addClass('bsm_section_2_image_overlay_active');
        });
        bsm_about_s2_text.on('mouseleave', function () {
            bsm_about_s2_img.removeClass('bsm_section_2_image_overlay_active');
        });

        var bsm_story_span = $('.bsm_our_story_content article .bsm_our_story_content_date span');
        var bsm_story_img = $('.bsm_our_story_content article .bsm_our_story_content_image figure');
        bsm_story_span.hover(function () {
            $(this).parent().parent().find('figure').addClass('bsm_our_story_image_overlay_active');
        });
        bsm_story_span.on('mouseleave', function () {
            bsm_story_img.removeClass('bsm_our_story_image_overlay_active');
        });

        var bsm_nav_ul_li_child = $('header .bsm_top_bar nav ul li ul');
        var bsm_nav_ul_li = $('header .bsm_top_bar nav ul li');
        $(document).on('click', 'nav ul li.bsm_nav_submenu span', function () {
            bsm_nav_ul_li_child.removeClass('bsm_nav_submenu_content_active');
            bsm_nav_ul_li.removeClass('bsm_nav_submenu_active');
            if ($(this).parent().hasClass('bsm_nav_submenu')) {
                $(this).parent().find('ul').addClass('bsm_nav_submenu_content_active');
                $(this).parent().addClass('bsm_nav_submenu_active');
            }
        });
        $(document).on('click', 'nav ul li.bsm_nav_submenu_active', function () {
            $(this).find('ul').removeClass('bsm_nav_submenu_content_active');
            $(this).removeClass('bsm_nav_submenu_active');
        });

        var bsm_shop_s2_col = $('.bsm_page_shop_class #bsm_section_2 #bsm_section_2_shop_content .col-md-6');
        var bsm_shop_s2_review = $('.bsm_page_shop_class #bsm_section_2 #bsm_section_2_shop_content .col-md-6 .bsm_section_2_shop_product_details_review i');
        var bsm_shop_s2_image = $('.bsm_section_2_shop_product_image');
        bsm_shop_s2_review.hover(function () {
            $(this).removeClass('fa fa-heart-o');
            $(this).addClass('fa fa-heart');
        });
        bsm_shop_s2_review.on('mouseleave', function () {
            $(this).removeClass('fa fa-heart');
            $(this).addClass('fa fa-heart-o');
        });
        bsm_shop_s2_col.hover(function () {
            $(this).find(bsm_shop_s2_image).addClass('bsm_section_2_shop_product_image_active');
        });
        bsm_shop_s2_col.on('mouseleave', function () {
            $(this).find(bsm_shop_s2_image).removeClass('bsm_section_2_shop_product_image_active');
        });

        var bsm_shop_s2_count = 6;
        var bsm_shop_s2_count_nr = $('#bsm_section_2_shop_content .col-md-6:lt(' + bsm_shop_s2_count + ')');
        bsm_shop_s2_count_nr.show();

        var bsm_shop_s2_pagination = $('#bsm_section_2_shop_pagination span');
        var bsm_shop_s2_pagination_active = $('#bsm_section_2_shop_pagination span.bsm_section_2_shop_pagination_active');
        var bsm_shop_s2_pagination_prev = $('#bsm_section_2_shop_pagination #bsm_section_2_shop_pagination_prev');
        var bsm_shop_s2_pagination_next = $('#bsm_section_2_shop_pagination #bsm_section_2_shop_pagination_next');
        bsm_shop_s2_pagination.on('click', function () {
            bsm_shop_s2_pagination.removeClass('bsm_section_2_shop_pagination_active');
            $(this).addClass('bsm_section_2_shop_pagination_active');
        });
        bsm_shop_s2_pagination_prev.on('click', function (pagination_prev) {
            pagination_prev.preventDefault();
            if (!$(bsm_shop_s2_pagination).first().hasClass('bsm_section_2_shop_pagination_active')) {
                $('#bsm_section_2_shop_pagination span.bsm_section_2_shop_pagination_active').removeClass('bsm_section_2_shop_pagination_active').prev().addClass('bsm_section_2_shop_pagination_active');
            }
        });
        bsm_shop_s2_pagination_next.on('click', function (pagination_prev) {
            pagination_prev.preventDefault();
            if (!$(bsm_shop_s2_pagination).last().hasClass('bsm_section_2_shop_pagination_active')) {
                $('#bsm_section_2_shop_pagination span.bsm_section_2_shop_pagination_active').removeClass('bsm_section_2_shop_pagination_active').next().addClass('bsm_section_2_shop_pagination_active');
            }
        });

        var bsm_shop_s2_gategories_a = $('#bsm_section_2_shop_content #bsm_shop_product_filter_categories ul li a');
        var bsm_shop_s2_gategories_li = $('#bsm_section_2_shop_content #bsm_shop_product_filter_categories ul li');
        var bsm_shop_s2_gategories_span = $('#bsm_section_2_categories_selected span');
        bsm_shop_s2_gategories_a.on('click', function (bsm_filter_categories) {
            bsm_filter_categories.preventDefault();
            bsm_shop_s2_gategories_li.removeClass('active');
            $(this).parent().addClass('active');
            bsm_shop_s2_gategories_span.html($(this).text());
        });

        var bsm_shop_s2_filters_label = $('#bsm_section_2_shop_content #bsm_shop_product_filter_radio ul li label');
        var bsm_shop_s2_filters_input = $('#bsm_section_2_shop_content #bsm_shop_product_filter_radio ul li label input');
        bsm_shop_s2_filters_label.on('click', function () {
            if (bsm_shop_s2_filters_input.is(':checked')) {
                bsm_shop_s2_filters_label.removeClass('active');
                $(this).addClass('active');
            } else {
                $(this).removeClass('active');
            }
        });

        var bsm_filters_price = $('#bsm_section_2_shop_content ul li.range span');
        var bsm_range = $('.range');
        var bsm_range_width = $('#bsm_section_2_shop_content ul li.range').width();
        if (bsm_range.length) {
            document.body.addEventListener('change', function () {
                var bsm_max_price = $("#bsm_section_2_shop_content ul li.range div").first();
                var bsm_min_price = $("#bsm_section_2_shop_content ul li.range div").last();
                var bsm_distance = bsm_range_width - bsm_max_price.position().left;
                $(bsm_filters_price).css({
                    'margin-left': bsm_min_price.position().left + 'px',
                    'margin-right': bsm_distance + 'px'
                });
                bsm_min_price.html('<span>' + bsm_min_price.attr('data-value') + '</span>');
                bsm_max_price.html('<span>' + bsm_max_price.attr('data-value') + '</span>');
            });
        }

        var bsm_filters_price_label = $("#bsm_section_2_shop_content #bsm_shop_product_filter_price label input");
        bsm_filters_price_label.on('keyup', function (e) {
            if ($(this).val() !== '') {
                if (Math.floor($(this).val()) == $(this).val() && $.isNumeric($(this).val())) {
                    $(this).css({
                        'border-color': '#20b247'
                    });
                } else {
                    $(this).css({
                        'border-color': '#cf3045'
                    });
                }
            } else {
                $(this).css({
                    'border-color': '#857a6b'
                });
            }
        });

        var bsm_pp_s2_q_plus = $('.bsm_section_2_product_page_content_quantity_plus');
        var bsm_pp_s2_q_minus = $('.bsm_section_2_product_page_content_quantity_minus');
        bsm_pp_s2_q_plus.on('click', function (e) {
            e.preventDefault();
            var fieldName = $(this).attr('field');
            var fieldName_input = $('input[name=' + fieldName + ']');
            var currentVal = parseInt(fieldName_input.val());
            if (!isNaN(currentVal)) {
                fieldName_input.val(currentVal + 1);
            } else {
                fieldName_input.val(0);
            }
        });
        bsm_pp_s2_q_minus.on('click', function (e) {
            e.preventDefault();
            var fieldName = $(this).attr('field');
            var fieldName_input_m = $('input[name=' + fieldName + ']');
            var currentVal = parseInt(fieldName_input_m.val());
            if (!isNaN(currentVal) && currentVal > 0) {
                fieldName_input_m.val(currentVal - 1);
            } else {
                fieldName_input_m.val(0);
            }
        });

        var bsm_cart_s3_delivery_label = $('.bsm_section_3_content_cart_step_2_delivery ul li label');
        var bsm_cart_s3_delivery_input = $('.bsm_section_3_content_cart_step_2_delivery ul li label input');
        bsm_cart_s3_delivery_label.on('click', function () {
            if (bsm_cart_s3_delivery_input.is(':checked')) {
                bsm_cart_s3_delivery_label.removeClass('active');
                $(this).addClass('active');
            } else {
                $(this).removeClass('active');
            }
        });

        var bsm_cart_s3_span = $('.bsm_section_3_content_cart_step_1 ul li.bsm_section_3_product_section ul li span');
        bsm_cart_s3_span.on('click', function (e) {
            $(this).parent().parent().parent().remove();
        });

        if ($(window).width() < 767) {

            var bsm_s6_content = $('.bsm_section_6_content');
            bsm_s6_content.hover(function () {
                bsm_s6_content.removeClass('bsm_section_6_content_767_active');
            });

            var bsm_767_js_move_to_cart = $('.bsm_767_js_move_to_cart');
            var bsm_nav_right = $('#bsm_nav_right');
            var bsm_nav_left = $('#bsm_nav_left');
            var bsm_logo = $('#bsm_logo');
            var bsm_767_js_move_to_nav = $('.bsm_767_js_move_to_navigation');
            bsm_767_js_move_to_cart.insertBefore('#bsm_cart_close_mobile');
            bsm_nav_right.prependTo('#bsm_navigation_open_mobile_content_nav');
            bsm_nav_left.prependTo('#bsm_navigation_open_mobile_content_nav');
            bsm_logo.insertAfter('#bsm_navigation_open_mobile_content_nav');
            bsm_767_js_move_to_nav.prependTo('#bsm_navigation_open_mobile_content');

            var bsm_body = $('body');
            var bsm_nav_open_m = $('#bsm_navigation_open_mobile');
            var bsm_nav_content_m = $('#bsm_navigation_open_mobile_content_nav');
            var bsm_nav_close_m = $('#bsm_navigation_close_mobile');
            bsm_nav_open_m.on('click', function () {
                $(this).fadeOut(500);
                bsm_nav_close_m.fadeIn(500);
                bsm_nav_content_m.css({
                    'opacity': "1",
                    '-webkit-transform': "translateY(0)",
                    '-moz-transform': "translateY(0)",
                    '-ms-transform': "translateY(0)",
                    '-o-transform': "translateY(0)",
                    'transform': "translateY(0)",
                    'visibility': "visible",
                    'transition': "opacity .4s 0s, transform .4s 0s, visibility .4s .4s"
                }, 500);
                bsm_body.css({
                    'overflow': 'hidden'
                });
            });
            bsm_nav_close_m.on('click', function () {
                $(this).fadeOut(500);
                bsm_nav_open_m.fadeIn(500);
                bsm_nav_content_m.css({
                    opacity: "0",
                    '-webkit-transform': "translateY(-100%)",
                    '-moz-transform': "translateY(-100%)",
                    '-ms-transform': "translateY(-100%)",
                    '-o-transform': "translateY(-100%)",
                    'transform': "translateY(-100%)",
                    visibility: "hidden",
                    transition: "opacity .4s 0s, transform .4s 0s, visibility .4s .4s"
                }, 500);
                bsm_body.css({
                    'overflow': 'visible'
                });
            });

            var bsm_cart_open_m = $('#bsm_cart_open_mobile');
            var bsm_cart_close_m = $('#bsm_cart_close_mobile');
            var bsm_cart_content_m = $('#bsm_cart_open_mobile_content');
            bsm_cart_open_m.on('click', function () {
                bsm_cart_content_m.css({
                    opacity: "1",
                    '-webkit-transform': "translateY(0)",
                    '-moz-transform': "translateY(0)",
                    '-ms-transform': "translateY(0)",
                    '-o-transform': "translateY(0)",
                    'transform': "translateY(0)",
                    visibility: "visible",
                    transition: "opacity .4s .4s, transform .4s .4s, visibility .4s 0s"
                }, 500);
                bsm_body.css({
                    'overflow': 'hidden'
                });
            });
            bsm_cart_close_m.on('click', function () {
                bsm_cart_content_m.css({
                    opacity: "0",
                    '-webkit-transform': "translateY(-100%)",
                    '-moz-transform': "translateY(-100%)",
                    '-ms-transform': "translateY(-100%)",
                    '-o-transform': "translateY(-100%)",
                    'transform': "translateY(-100%)",
                    visibility: "hidden",
                    transition: "opacity .4s 0s, transform .4s 0s, visibility .4s .4s"
                }, 500);
                bsm_body.css({
                    'overflow': 'visible'
                });
            });

            var bsm_filters_open_m = $('#bsm_shop_page_filters_mobile_open');
            var bsm_filters_close_m = $('#bsm_shop_page_filters_mobile_close');
            var bsm_filters_form_m = $('#bsm_shop_page_filters_form');
            bsm_filters_open_m.on('click', function () {
                $(this).fadeOut(500);
                bsm_filters_close_m.fadeIn(500);
                bsm_filters_form_m.css({
                    opacity: "1",
                    '-webkit-transform': "translateY(0)",
                    '-moz-transform': "translateY(0)",
                    '-ms-transform': "translateY(0)",
                    '-o-transform': "translateY(0)",
                    'transform': "translateY(0)",
                    visibility: "visible",
                    transition: "opacity .4s 0s, transform .4s 0s, visibility .4s .4s"
                }, 500);
                bsm_body.css({
                    'overflow': 'hidden'
                });
            });
            bsm_filters_close_m.on('click', function () {
                $(this).fadeOut(500);
                bsm_filters_open_m.fadeIn(500);
                bsm_filters_form_m.css({
                    opacity: "0",
                    '-webkit-transform': "translateY(-100%)",
                    '-moz-transform': "translateY(-100%)",
                    '-ms-transform': "translateY(-100%)",
                    '-o-transform': "translateY(-100%)",
                    'transform': "translateY(-100%)",
                    visibility: "hidden",
                    transition: "opacity .4s 0s, transform .4s 0s, visibility .4s .4s"
                }, 500);
                bsm_body.css({
                    'overflow': 'visible'
                });
            });
        }

        $(window).stellar();
    });
})(jQuery);
