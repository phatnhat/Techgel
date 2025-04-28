const userTheme = localStorage.getItem("theme") || "light"; // fallback
console.log(userTheme);
const html = document.documentElement;
html.setAttribute("data-theme", userTheme);
const $themeBtn = $("#theme-toggle");
if (userTheme === "dark") {
  $themeBtn.prop('checked', true)
} else {
  $themeBtn.prop('checked', false)
}

fitty('.fit-text');

$(document).ready(function () {
  addSplitCollabAnimation("chars");
  addSplitCollabAnimation("words");
  addStickyNav();
  initThemeToggle();
  langToggle();
  recruitmentDetailsToggle();
});

function recruitmentDetailsToggle() {
  $('[data-target="#recruitment-details-modal"]').on('click', function (e){
    $('#recruitment-details-modal').find('.title').html($(this).attr('data-title'));
    $('#recruitment-details-modal').find('.wp-post-image').attr('src', $(this).attr('data-image_url'));
    $('#recruitment-details-modal').find('.quantity').html($(this).attr('data-quantity'));
    $('#recruitment-details-modal').find('.qualification').html($(this).attr('data-qualification'));
    $('#recruitment-details-modal').find('.experience').html($(this).attr('data-experience'));
    $('#recruitment-details-modal').find('.salary').html($(this).attr('data-salary'));
    $('#recruitment-details-modal').find('.workplace').html($(this).attr('data-workplace'));
    $('#recruitment-details-modal').find('.expiration_date').html($(this).attr('data-expiration_date'));
    $('#recruitment-details-modal').find('.description').html($(this).attr('data-description'));

    $("#recruitment-details-modal").modal('toggle');
  });
  $('[data-dismiss="recruitment-details-modal"]').on('click', function(e){
    $("#recruitment-details-modal").modal('hide');
  })
}

function langToggle(){
  $(".lang-flag").click(function(){
    $(".language-dropdown").toggleClass("open");
  });
}

// Functionality
function initThemeToggle() {
  const html = document.documentElement;
  $(".switch__input").on("click", function () {
    console.log('asf');
    if(this.checked){
        html.setAttribute("data-theme", "dark");
        localStorage.setItem("theme", "dark");
    }else{
        html.setAttribute("data-theme", "light");
        localStorage.setItem("theme", "light");
    }
  });

}

function addStickyNav() {
  const $header = $(".tmp-header-area-start");
  const $nav = $(".tmp-nav-area-one");

  if ($header.length === 0 || $nav.length === 0) return;

  const headerBottom = $header.offset().top + $header.outerHeight();

  $(window).on("scroll", function () {
    if ($(window).scrollTop() >= headerBottom) {
      $nav.addClass("is-sticky");
    } else {
      $nav.removeClass("is-sticky");
    }
  });
}

function addSplitCollabAnimation(type = "chars") {
  $(".split-collab-" + type).each(function () {
    const $el = $(this);

    const split = new SplitText($el, {
      type: type,
    });

    const targets = split[type]; // Dynamically get split.chars, split.words, or split.lines

    const tl = gsap.timeline({
      scrollTrigger: {
        trigger: $el,
        start: "top 85%",
        once: true,
        onEnter: () => $el.removeClass("split-collab-" + type),
      },
    });

    tl.set($el, { opacity: 1 }).from(targets, {
      duration: 0.5,
      autoAlpha: 0,
      x: 50,
      stagger: { amount: 1 },
      ease: "back.out(1)",
    });
  });
}

function stickyNavBelowHeader() {
  const $header = $(".tmp-header-area-start");
  const $nav = $(".tmp-nav-area-one");

  if (!$header.length || !$nav.length) return;

  const headerBottom = $header.offset().top + $header.outerHeight();

  $(window).on("scroll", function () {
    if ($(window).scrollTop() >= headerBottom) {
      $nav.addClass("is-sticky");
    } else {
      $nav.removeClass("is-sticky");
    }
  });
}

// Phat's code

$('#mobile-menu-active').metisMenu();
$(document).on("click", "#side-collups, #side-collups-nav", function (e) {
  if(this.id === 'side-collups'){
      $('.side-hide .body').show();
      $('.side-hide .mobile-menu-main').hide();
  } else{
    $('.side-hide .body').hide();
    $('.side-hide .mobile-menu-main').show();
  }

  $(".side-hide").addClass("show");
  $("#overlay_every-where").addClass("bgshow");

  $('#side-collups').removeClass("display");
});

$(document).on("click", "#close-slide__main", function () {
  $(".side-hide").removeClass("show");
  $("#overlay_every-where").removeClass("bgshow");
  $("#side-collups").addClass("display");
});
$(document).on("click", "#overlay_every-where", function () {
  $(".side-hide").removeClass("show");
  $("#overlay_every-where").removeClass("bgshow");
  $("#side-collups").addClass("display");
});
// for onepage mobile menu item
$(document).on("click", ".onepage .mainmenu li a", function () {
  $(".side-hide").removeClass("show");
  $("#overlay_every-where").removeClass("bgshow");
  $("#side-collups").addClass("display");
});

// $(window).scroll(function () {
//     if ($(this).scrollTop() > 150) {
//         $('.header--sticky').addClass('sticky')
//     } else {
//         $('.header--sticky').removeClass('sticky')
//     }
// });

$(document).ready(function () {
  var swiper = new Swiper(".mySwiper-banner-one", {
    spaceBetween: 0,
    slidesPerView: 1,
    speed: 500,
    effect: "slide",
    autoplay: {
      delay: 10000,
      disableOnInteraction: false,
    },
    fadeEffect: {
      crossFade: true,
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
        slidesPerView: 3,
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
      },
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
  $(".slider_projects").slick({
    slidesToShow: 3,
    autoplay: true,
    autoplaySpeed: 5000,
    pauseOnFocus: false,
    pauseOnHover: false,
    centerMode: true,
    centerPadding: "120px",
    speed: 1000,
    cssEase: "cubic-bezier(0.7, 0, 0.3, 1)",
    infinite: true,
    dots: true,
    arrows: true,
    prevArrow: '<div class="left_nav"><i class="fa fa-angle-left"></i></div>',
    nextArrow: '<div class="right_nav"><i class="fa fa-angle-right"></i></div>',
    responsive: [
      {
        breakpoint: 1180,
        settings: {
          slidesToShow: 2,
          dots: true,
          centerMode: false,
          centerPadding: "0",
        },
      },
      {
        breakpoint: 767,
        settings: {
          slidesToShow: 1,
          dots: true,
          centerMode: false,
          centerPadding: "0",
        },
      },
    ],
  });
  $(".partner_slider").slick({
    slidesToShow: 3,
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
        },
      },
      {
        breakpoint: 767,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 2,
          dots: true,
          arrows: false,
        },
      },
    ],
  });
  $(".slider_overview").slick({
    slidesToShow: 3,
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
        },
      },
      {
        breakpoint: 767,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 2,
          dots: true,
          arrows: false,
        },
      },
    ],
  });
});
$(document).ready(function () {
  // Swiper: Slider
  new Swiper(".swiper-container-style-two", {
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
        spaceBetween: 30,
      },
      1028: {
        slidesPerView: 2,
        spaceBetween: 30,
      },
      480: {
        slidesPerView: 1,
        spaceBetween: 10,
      },
      0: {
        slidesPerView: 1,
        spaceBetween: 10,
      },
    },
  });
});

jQuery(window).on("scroll", function () {
  if (jQuery(this).scrollTop() > 50) {
    jQuery(".progress-wrap").addClass("active-progress");
  } else {
    jQuery(".progress-wrap").removeClass("active-progress");
  }
});

$(document).on("click", ".progress-wrap", function (event) {
  event.preventDefault();
  jQuery("html, body").animate({ scrollTop: 0 }, 0);
  return false;
});

if (window.innerWidth > 991) {
  gsap.registerPlugin(ScrollTrigger);
  gsap.registerPlugin(SplitText);

  $(document).ready(function () {
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
  });
  if (window.innerWidth < 1023) {
    const counterArray = gsap.utils.toArray(
      ".counter_animation .counter__anim"
    );
    counterArray.forEach((item, i) => {
      let counterTl = gsap.timeline({
        scrollTrigger: {
          trigger: item,
          start: "top center+=200",
        },
      });
      counterTl.to(item, {
        y: 0,
        opacity: 1,
        ease: "bounce",
        duration: 1.5,
      });
    });
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
      },
    });
  }
}
counterJumpanimation();

sal({
  threshold: 0.1,
  once: true,
});

/* Click event */
$(document).ready(function () {
  $("#filter_projects-btn").click(function () {
    $(".filter_advance").toggle();
  });
});

/* Masonry */
$(document).ready(function () {
  // var $grid = $(".grid").masonry({
  //   itemSelector: ".grid_item",
  //   columnWidth: ".grid-sizer",
  //   percentPosition: true,
  //   gutter: 15,
  // });
  // imagesLoaded($(".grid")).on('progress', function() {
  //   $grid.layout();
  // });
  $('.grid').colcade({
    items: '.grid_item'
  });
});

/* Isotope */
$(document).ready(function() {

});

/* Fancybox */
$(document).ready(function(){
  Fancybox.bind("[data-fancybox]", {});
})

/* Nanogallery2 */
$(document).ready(function () {
  $("#construction-nanogallery2").nanogallery2({
    items: [
      {
        src: "https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380",
        srct: "https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380",
        srct: "https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380",
        srct: "https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740",
        srct: "https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740",
      },
      {
        src: "https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380",
        srct: "https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380",
        srct: "https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380",
        srct: "https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380",
        srct: "https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740",
        srct: "https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740",
      },
      {
        src: "https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380",
        srct: "https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-silhouette_1127-3246.jpg?t=st=1743154790~exp=1743158390~hmac=dec3c948baedea392b40a4a521397a6f5c9fca1070422333b7fc33b5faa980b6&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380",
        srct: "https://img.freepik.com/free-photo/workers-examining-work_1122-970.jpg?t=st=1743148913~exp=1743152513~hmac=71ba4023dcfbba29bffc282c8f28f95f552af73f67b4cb3ffbd63ec9fac353e3&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380",
        srct: "https://img.freepik.com/free-photo/civil-engineer-construction-worker-manager-holding-digital-tablet-blueprints-talking-planing-about-construction-site-cooperation-teamwork-concept_640221-156.jpg?t=st=1743155207~exp=1743158807~hmac=b02ebd1aeff708ac3638af70307b989ec875dc09d8cb979223e2cdac11d23f57&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-tall-concrete-pylon-bridge-using-tower-crane_1112-1141.jpg?t=st=1743155270~exp=1743158870~hmac=46186e78fa4b5aa6b7cf9709bfff9f7318bad4b4b15525c00387a3dd60b98032&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380",
        srct: "https://img.freepik.com/free-photo/construction-silhouette_1127-2991.jpg?t=st=1743155290~exp=1743158890~hmac=3412c26aedb354c11d3998e95e81149c2f9e5261b6835c65656101073c31c19d&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380",
        srct: "https://img.freepik.com/free-photo/beautiful-view-construction-site-city-sunset_181624-9347.jpg?t=st=1743155336~exp=1743158936~hmac=e8716bb6dbe1fb5c3fbfcfe125e8cffa3dced3d89b3960618212e8310f9582e7&w=1380",
      },
      {
        src: "https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740",
        srct: "https://img.freepik.com/free-photo/large-building-site_1127-3251.jpg?t=st=1743155358~exp=1743158958~hmac=5a9d9e486f072a5ce432baf1f7b33f5ed6d08fb6f9478c70adf1e29b65e38545&w=740",
      },
      {
        src: "https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380",
        srct: "https://img.freepik.com/free-photo/building-construction-worker-site-with-architect_23-2149124266.jpg?t=st=1743155407~exp=1743159007~hmac=5edb90c7b809f71e3cb7659d7b8a340b70601ab58794099fe6377caaa2be167e&w=1380",
      },
    ],
    locationHash: false,

    thumbnailWidth: "auto",
    thumbnailHeight: 250,

    // hover effects
    thumbnailHoverEffect2:
      "image_scale_1.00_1.10_5000|image_rotateZ_0deg_4deg_5000",
  });
});

/* Clamp.js */
$(document).ready(function () {
  let news_descriptions = document.querySelectorAll(".news-body .description");
  for (var i = 0; i < news_descriptions.length; i++) {
    $clamp(news_descriptions[i], { clamp: 3 });
  }

  let news_title = document.querySelectorAll(
    ".news-body .title, single-news-recent-post-sidebar .title"
  );
  for (var i = 0; i < news_title.length; i++) {
    $clamp(news_title[i], { clamp: 3 });
  }
});

/* Scroll sustainable-development */
document.querySelectorAll(".scroll-btn").forEach((button) => {
  button.addEventListener("click", function () {
    const targetId = this.getAttribute("data-target");
    const targetElement = document.getElementById(targetId);

    if (targetElement) {
      targetElement.scrollIntoView({
        behavior: "smooth",
        block: "center",
      });
    }
  });
});

/* countUp.js */
$(document).ready(function () {
  const counterUp = window.counterUp.default;
  const callback = (entries) => {
    entries.forEach((entry) => {
      const el = entry.target;
      if (entry.isIntersecting && !el.classList.contains("is-visible")) {
        counterUp(el, {
          duration: 2000,
          delay: 16,
        });
        el.classList.add("is-visible");
      }
    });
  };
  const IO = new IntersectionObserver(callback, { threshold: 1 });
  const elms = document.querySelectorAll(".counter");
  for (var el of elms) IO.observe(el);
});
