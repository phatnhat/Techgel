$(document).on('click', '#side-collups', function () {
    $("#side-hide").addClass("show");
    $("#overlay_every-where").addClass("bgshow");
});
$(document).on('click', '#close-slide__main', function () {
    $("#side-hide").removeClass("show");
    $("#overlay_every-where").removeClass("bgshow");
});
$(document).on('click', '#overlay_every-where', function () {
    $("#side-hide").removeClass("show");
    $("#overlay_every-where").removeClass("bgshow");
});
// for onepage mobile menu item
$(document).on('click', '.onepage .mainmenu li a', function () {
    $("#side-hide").removeClass("show");
    $("#overlay_every-where").removeClass("bgshow");
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
            delay: 3000,
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
        dots: true,
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

sal({
    threshold: 0.1,
    once: true,
});

counterJumpanimation()