$(document).on('click', '#side-collups', function () {
    $("#side-hide").addClass("show");
    $("#overlay_every-where").addClass("bgshow");

    $(this).removeClass('display');
});
$(document).on('click', '#close-slide__main', function () {
    $("#side-hide").removeClass("show");
    $("#overlay_every-where").removeClass("bgshow");
    $('#side-collups').addClass('display');
    console.log($('#side-collups'));
});
$(document).on('click', '#overlay_every-where', function () {
    $("#side-hide").removeClass("show");
    $("#overlay_every-where").removeClass("bgshow");
    $('#side-collups').addClass('display');
});
// for onepage mobile menu item
$(document).on('click', '.onepage .mainmenu li a', function () {
    $("#side-hide").removeClass("show");
    $("#overlay_every-where").removeClass("bgshow");
    $('#side-collups').addClass('display');
});

$(window).scroll(function () {
    if ($(this).scrollTop() > 150) {
        $('.header--sticky').addClass('sticky')
    } else {
        $('.header--sticky').removeClass('sticky')
    }
});

$(document).ready(function(){
    var swiper = new Swiper(".mySwiper-banner-one", {
        spaceBetween: 0,
        slidesPerView: 1,
        speed: 500,
        effect: 'slide',
        autoplay: {
            delay: 10000,
            disableOnInteraction: false,
        },
        fadeEffect: {
            crossFade: true
        },
        loop: true,
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
    });
});
$(document).ready(function () {
    var Homecarousel = new Swiper(".mySwiper-project-1", {
        slidesPerView: 5,
        spaceBetween: 30,
        loop: true,
        centeredSlides: true,
        speed: 2000,
        autoplay: {
            delay: 18000,
            disableOnInteraction: false,
        },
        // loopFillGroupWithBlank: true,
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
        breakpoints: {
            1500: {
                slidesPerView: 5,
            },
            1199: {
                slidesPerView:3,
            },
            991: {
                slidesPerView: 3,
            },
            767: {
                slidesPerView: 2,
            },
            575: {
                slidesPerView: 1,
            },
            0: {
                slidesPerView: 1,
            }
        },
    });

    var pacSwiper = new Swiper(".pacSwiper", {
        slidesPerView: 8,
        pagination: {
            el: ".swiper-pagination",
        },
    });
});
$(document).ready(function () {
    $('.slider_projects').slick({
        slidesToShow: 3,
        autoplay: true,
        autoplaySpeed: 5000,
        pauseOnFocus: false,
        pauseOnHover: false,
        centerMode: true,
        centerPadding: '120px',
        speed: 1000,
        cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)',
        infinite: true,
        dots: true,
        arrows: true,
        prevArrow: '<div class="left_nav"><i class="fa fa-angle-left"></i></div>',
        nextArrow: '<div class="right_nav"><i class="fa fa-angle-right"></i></div>',
        responsive: [
            {
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                    dots: true,
                    centerMode: false,
                    centerPadding: '0',
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 1,
                    dots: true,
                    centerMode: false,
                    centerPadding: '0',
                }
            },
        ]
    });
    $('.partner_slider').slick({
        slidesToShow: 6,
        autoplay: true,
        autoplaySpeed: 5000,
        pauseOnFocus: false,
        pauseOnHover: false,
        speed: 1000,
        infinite: false,
        dots: false,
        arrows: false,
        responsive: [
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 4,
                    dots: true,
                    arrows: false,
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2,
                    dots: true,
                    arrows: false,
                }
            },
        ]
    });
});
$(document).ready(function() {
    // Swiper: Slider
    new Swiper('.swiper-container-style-two', {
        loop: true,
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
        slidesPerView: 2,
        paginationClickable: true,
        spaceBetween: 20,
        allowSlidePrev: true,
        allowSlideNext: true,
        breakpoints: {
            1920: {
                slidesPerView: 2,
                spaceBetween: 30
            },
            1028: {
                slidesPerView: 2,
                spaceBetween: 30
            },
            480: {
                slidesPerView: 1,
                spaceBetween: 10
            },
            0: {
                slidesPerView: 1,
                spaceBetween: 10
            }
        }
    })
});

jQuery(window).on('scroll', function() {
    if (jQuery(this).scrollTop() > 50) {
        jQuery('.progress-wrap').addClass('active-progress');
    } else {
        jQuery('.progress-wrap').removeClass('active-progress');
    }
});
$(document).on('click', '.progress-wrap', function(event) {
    event.preventDefault();
    jQuery('html, body').animate({scrollTop: 0}, 0);
    return false;
});




if (window.innerWidth > 991) {
    gsap.registerPlugin(ScrollTrigger);
    gsap.registerPlugin(SplitText);

    $(document).ready(function () {
        let addAnimation = function () {
            $(".split-collab").each(function (index) {
                const textInstance = $(this);
                const text = new SplitText(textInstance, {
                    type: "chars",
                });

                let letters = text.chars;

                let tl = gsap.timeline({
                    scrollTrigger: {
                        trigger: textInstance,
                        start: "top 85%",
                        end: "top 85%",
                        onComplete: function () {
                            textInstance.removeClass(".split-collab");
                        }
                    }
                });

                tl.set(textInstance, { opacity: 1 }).from(letters, {
                    duration: .5,
                    autoAlpha: 0,
                    x: 50,
                    // scaleY: 0,
                    // skewX: 50,
                    stagger: { amount: 1 },
                    ease: "back.out(1)"
                });
            });
        };

        addAnimation();

        window.addEventListener("resize", function (event) {
            if ($(window).width() >= 992) {
                addAnimation();
            }
        });

    });
}

function counterJumpanimation() {
    gsap.registerPlugin(ScrollTrigger);
    gsap.set(".counter_animation .counter__anim", {
        y: -100,
        opacity: 0,
    })
    if (window.innerWidth < 1023) {
        const counterArray = gsap.utils.toArray(".counter_animation .counter__anim")
        counterArray.forEach((item, i) => {
            let counterTl = gsap.timeline({
                scrollTrigger: {
                    trigger: item,
                    start: "top center+=200",
                }
            })
            counterTl.to(item, {
                y: 0,
                opacity: 1,
                ease: "bounce",
                duration: 1.5,
            })
        })
    } else {
        gsap.to(".counter_animation .counter__anim", {
            scrollTrigger: {
                trigger: ".counter_animation",
                start: "top center+=300",
            },
            y: 0,
            opacity: 1,
            ease: "bounce",
            duration: 1.5,
            stagger: {
                each: 0.3,
            }
        })
    }

}
counterJumpanimation();

sal({
    threshold: 0.1,
    once: true,
});


/* Click event */
$(document).ready(function(){
    $('#filter_projects-btn').click(function(){
        $('.filter_advance').toggle();
    })
});


/* Masonry */
$(document).ready( function() {
    var $grid = $('.grid').masonry({
        itemSelector: '.grid_item',
        columnWidth: '.grid-sizer',
        percentPosition: true,
        gutter: 15
    });
});


/* Nanogallery2 */
$(document).ready(function () {
    $("#construction-nanogallery2").nanogallery2({
        items:[
            {
                src:'https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380',
            },
            {   src:'https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380',
                srct:'https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380',
                srct:'https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380',
                srct:'https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740',
                srct:'https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740'
            },
            {   src:'https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380',
                srct:'https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380'
            },
            {
                src:'https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380',
            },
            {   src:'https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380',
                srct:'https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380',
                srct:'https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380',
                srct:'https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740',
                srct:'https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740'
            },
            {   src:'https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380',
                srct:'https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380'
            },
            {
                src:'https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380',
            },
            {   src:'https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380',
                srct:'https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380',
                srct:'https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380',
                srct:'https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380',
                srct:'https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380'
            },
            {   src:'https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740',
                srct:'https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740'
            },
            {   src:'https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380',
                srct:'https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380'
            },
        ],
        itemsBaseURL:     'http://nanogallery2.nanostudio.org/samples/',
        locationHash:     false,

        thumbnailWidth:   'auto',
        thumbnailHeight:  250,

        // hover effects
        thumbnailHoverEffect2: 'label_font-size_1em_1.5em|title_backgroundColor_rgba(255,255,255,0.34)_rgba(((84,132,12,0.8)|title_color_#000_#fff|image_scale_1.00_1.10_5000|image_rotateZ_0deg_4deg_5000',

    });
});

/* Clamp.js */
$(document).ready(function(){
    let news_descriptions = document.querySelectorAll('.news-body .description');
    for(var i = 0; i < news_descriptions.length; i++){
        $clamp(news_descriptions[i], {clamp: 3});
    }

    let news_title = document.querySelectorAll('.news-body .title, single-news-recent-post-sidebar .title');
    for(var i = 0; i < news_title.length; i++){
        $clamp(news_title[i], {clamp: 3});
    }
});

/* Scroll sustainable-development */
document.querySelectorAll('.scroll-btn').forEach(button => {
    button.addEventListener('click', function() {
        const targetId = this.getAttribute('data-target');
        const targetElement = document.getElementById(targetId);

        if (targetElement) {
            targetElement.scrollIntoView({
                behavior: 'smooth',
                block: 'center'
            });
        }
    });
});


/* countUp.js */
$(document).ready(function(){
    const counterUp = window.counterUp.default;
    const callback = entries => {
        entries.forEach( entry => {
            const el = entry.target
            if ( entry.isIntersecting && ! el.classList.contains( 'is-visible' ) ) {
                counterUp( el, {
                    duration: 2000,
                    delay: 16,
                } )
                el.classList.add( 'is-visible' )
            }
        } )
    }
    const IO = new IntersectionObserver( callback, { threshold: 1 } )
    const elms = document.querySelectorAll( '.counter' );
    for(var el of elms) IO.observe(el);
});