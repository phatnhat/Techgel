[1mdiff --git a/src/main/java/com/techgel/TechgelApplication.java b/src/main/java/com/techgel/TechgelApplication.java[m
[1mindex 431b6b5..1bcae8e 100644[m
[1m--- a/src/main/java/com/techgel/TechgelApplication.java[m
[1m+++ b/src/main/java/com/techgel/TechgelApplication.java[m
[36m@@ -3,6 +3,7 @@[m [mpackage com.techgel;[m
 import org.springframework.boot.SpringApplication;[m
 import org.springframework.boot.autoconfigure.SpringBootApplication;[m
 import org.springframework.boot.autoconfigure.domain.EntityScan;[m
[32m+[m
 import org.springframework.data.jpa.repository.config.EnableJpaAuditing;[m
 [m
 @SpringBootApplication[m
[1mdiff --git a/src/main/resources/application.properties b/src/main/resources/application.properties[m
[1mindex 982aec3..c12b5dd 100644[m
[1m--- a/src/main/resources/application.properties[m
[1m+++ b/src/main/resources/application.properties[m
[36m@@ -1,5 +1,13 @@[m
 spring.application.name=Techgel[m
 [m
[32m+[m[32m#spring.datasource.url=jdbc:mysql://root:SDGkiCYwFoTGTDCagFTnPLpzGHOKNWLD@trolley.proxy.rlwy.net:51181/railway?createDatabaseIfNotExist=true[m
[32m+[m[32m#spring.datasource.username=root[m
[32m+[m[32m#spring.datasource.password=SDGkiCYwFoTGTDCagFTnPLpzGHOKNWLD[m
[32m+[m[32m#spring.datasource.driver-class-name=com.mysql.jdbc.Driver[m
[32m+[m
[32m+[m[32mspring.datasource.url=jdbc:mysql://localhost:3306/techgel?createDatabaseIfNotExist=true[m
[32m+[m[32mspring.datasource.username=root[m
[32m+[m[32mspring.datasource.password=nhatphat0[m
 spring.datasource.driver-class-name=com.mysql.jdbc.Driver[m
 [m
 spring.jpa.show-sql=false[m
[1mdiff --git a/src/main/resources/static/css/base.css b/src/main/resources/static/css/base.css[m
[1mdeleted file mode 100644[m
[1mindex 3a6ced9..0000000[m
[1m--- a/src/main/resources/static/css/base.css[m
[1m+++ /dev/null[m
[36m@@ -1,129 +0,0 @@[m
[31m-@import url("https://fonts.googleapis.com/css2?family=Manrope:wght@200;300;400;500;600;700;800&display=swap");[m
[31m-@import url("https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700;800&family=Roboto:wght@100;300;400;500;700;900&display=swap");[m
[31m-@import url("https://fonts.googleapis.com/css2?family=Lexend+Deca:wght@100..900&display=swap");[m
[31m-:root {[m
[31m-  --themeDarker: #79140f;[m
[31m-  --themeDark: #a51b14;[m
[31m-  --themeDarkAlt: #c32017;[m
[31m-  --themePrimary: #DA251A;[m
[31m-  --themeSecondary: #dd3b32;[m
[31m-  --themeTertiary: #e8746e;[m
[31m-  --themeLight: #f4b6b3;[m
[31m-  --themeLighter: #f9d8d6;[m
[31m-  --themeLighterAlt: #fdf5f5;[m
[31m-  --black: #000000;[m
[31m-  --white: #ffffff;[m
[31m-  --neutralDark: #201f1e;[m
[31m-  --neutralPrimary: #323130;[m
[31m-  --neutralPrimaryAlt: #3b3a39;[m
[31m-  --neutralSecondary: #605e5c;[m
[31m-  --neutralTertiary: #a19f9d;[m
[31m-  --neutralTertiaryAlt: #c8c6c4;[m
[31m-  --neutralQuaternaryAlt: #e1dfdd;[m
[31m-  --neutralLight: #edebe9;[m
[31m-  --neutralLighter: #f3f2f1;[m
[31m-  --neutralLighterAlt: #faf9f8;[m
[31m-  --font-primary: arial, sans-serif;[m
[31m-  --font-secondary: "Roboto", sans-serif;[m
[31m-}[m
[31m-[m
[31m-[data-theme=dark] {[m
[31m-  --themeDarker: #fbe9e7;[m
[31m-  --themeDark: #f4b6b3;[m
[31m-  --themeDarkAlt: #e8746e;[m
[31m-  --themePrimary: #dd3b32;[m
[31m-  --themeSecondary: #c32017;[m
[31m-  --themeTertiary: #a51b14;[m
[31m-  --themeLight: #79140f;[m
[31m-  --themeLighter: #4a0e0b;[m
[31m-  --themeLighterAlt: #2a0504;[m
[31m-  --black: #ffffff;[m
[31m-  --white: #000000;[m
[31m-  --neutralDark: #fafafa;[m
[31m-  --neutralPrimary: #e0e0e0;[m
[31m-  --neutralPrimaryAlt: #d4d4d4;[m
[31m-  --neutralSecondary: #a8a8a8;[m
[31m-  --neutralTertiary: #808080;[m
[31m-  --neutralTertiaryAlt: #666666;[m
[31m-  --neutralQuaternaryAlt: #4d4d4d;[m
[31m-  --neutralLight: #3a3a3a;[m
[31m-  --neutralLighter: #2a2a2a;[m
[31m-  --neutralLighterAlt: #1a1a1a;[m
[31m-  --font-primary: arial, sans-serif;[m
[31m-  --font-secondary: "Roboto", sans-serif;[m
[31m-}[m
[31m-[m
[31m-:root {[m
[31m-  --alwaysWhite: #ffffff;[m
[31m-  --alwaysBlack: #000000;[m
[31m-  --font-size-base: 16px;[m
[31m-  --font-size-h1: 3.5rem;[m
[31m-  --font-size-h2: 2.75rem;[m
[31m-  --font-size-h3: 2.25rem;[m
[31m-  --font-size-h4: 1.75rem;[m
[31m-  --font-size-h5: 1.5rem;[m
[31m-  --font-size-h6: 1.25rem;[m
[31m-  /* Paragraphs */[m
[31m-  --font-size-p: 1rem;[m
[31m-  --font-size-p-bold: 1.125rem;[m
[31m-  --font-size-p-small: 0.875rem;[m
[31m-  --font-size-p-small-bold: 0.875rem;[m
[31m-  /* Font weights */[m
[31m-  --font-weight-bold: 700;[m
[31m-  --font-weight-medium: 500;[m
[31m-  --font-weight-regular: 400;[m
[31m-  --font-weight-light: 300;[m
[31m-}[m
[31m-[m
[31m-@media (max-width: 1023px) {[m
[31m-  :root {[m
[31m-    --font-size-p: 0.9375rem;[m
[31m-    --font-size-p-bold: 1.0625rem;[m
[31m-    --font-size-p-small: 0.8125rem;[m
[31m-    --font-size-p-small-bold: 0.8125rem;[m
[31m-    --font-size-h1: 2.5rem;[m
[31m-    --font-size-h2: 2.125rem;[m
[31m-    --font-size-h3: 1.75rem;[m
[31m-    --font-size-h4: 1.5rem;[m
[31m-    --font-size-h5: 1.25rem;[m
[31m-    --font-size-h6: 1.125rem;[m
[31m-  }[m
[31m-}[m
[31m-@media (max-width: 767px) {[m
[31m-  :root {[m
[31m-    --font-size-p: 0.875rem;[m
[31m-    --font-size-p-bold: 1rem;[m
[31m-    --font-size-p-small: 0.75rem;[m
[31m-    --font-size-p-small-bold: 0.75rem;[m
[31m-    --font-size-h1: 2rem;[m
[31m-    --font-size-h2: 1.75rem;[m
[31m-    --font-size-h3: 1.5rem;[m
[31m-    --font-size-h4: 1.25rem;[m
[31m-    --font-size-h5: 1rem;[m
[31m-    --font-size-h6: 0.875rem;[m
[31m-  }[m
[31m-}[m
[31m-html {[m
[31m-  width: fit-content;[m
[31m-  font-size: 16px;[m
[31m-}[m
[31m-[m
[31m-.content-wrapper {[m
[31m-  width: 100vw;[m
[31m-}[m
[31m-[m
[31m-.about-area {[m
[31m-  background-color: var(--white);[m
[31m-}[m
[31m-[m
[31m-.section-head .title {[m
[31m-  color: var(--black);[m
[31m-  font-size: var(--font-size-h2);[m
[31m-  line-height: 2.8125rem;[m
[31m-  margin-bottom: 0;[m
[31m-  font-weight: var(--font-weight-bold);[m
[31m-  margin-bottom: 0 !important;[m
[31m-  font-family: var(--font-secondary);[m
[31m-}[m
[31m-[m
[31m-/*# sourceMappingURL=base.css.map */[m
[1mdiff --git a/src/main/resources/static/css/base.css.map b/src/main/resources/static/css/base.css.map[m
[1mdeleted file mode 100644[m
[1mindex 1e103e0..0000000[m
[1m--- a/src/main/resources/static/css/base.css.map[m
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-{"version":3,"sourceRoot":"","sources":["../scss/_variables.scss","../scss/base.scss"],"names":[],"mappings":"AAAQ;AACA;AACA;AAER;EAEE;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EAGA;EACA;EAGA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EAEA;EACA;;;AAGF;EAEE;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EAGA;EACA;EAGA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EACA;EAGA;EACA;;;AAIF;EACE;EACA;EAEA;EAEA;EACA;EACA;EACA;EACA;EACA;AAEA;EACA;EACA;EACA;EACA;AAEA;EACA;EACA;EACA;EACA;;;AAGF;EACE;IACE;IACA;IACA;IACA;IAEA;IACA;IACA;IACA;IACA;IACA;;;AAIJ;EACE;IACE;IACA;IACA;IACA;IAEA;IACA;IACA;IACA;IACA;IACA;;;AC1HJ;EACI;EACA;;;AAGJ;EACI;;;AAGJ;EACI;;;AAGJ;EACI;EACA;EACA;EACA;EACA;EACA;EACA","file":"base.css"}[m
\ No newline at end of file[m
[1mdiff --git a/src/main/resources/static/css/scssStyling.css.map b/src/main/resources/static/css/scssStyling.css.map[m
[1mdeleted file mode 100644[m
[1mindex 7793412..0000000[m
[1m--- a/src/main/resources/static/css/scssStyling.css.map[m
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-{"version":3,"sourceRoot":"","sources":[],"names":[],"mappings":"","file":"scssStyling.css"}[m
\ No newline at end of file[m
[1mdiff --git a/src/main/resources/static/css/somestyle.css.map b/src/main/resources/static/css/somestyle.css.map[m
[1mdeleted file mode 100644[m
[1mindex a311efa..0000000[m
[1m--- a/src/main/resources/static/css/somestyle.css.map[m
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-{"version":3,"sourceRoot":"","sources":["../scss/somestyle.scss"],"names":[],"mappings":"AAAA;EACI","file":"somestyle.css"}[m
\ No newline at end of file[m
[1mdiff --git a/src/main/resources/static/css/style.css b/src/main/resources/static/css/style.css[m
[1mindex e1b2ba2..244d094 100644[m
[1m--- a/src/main/resources/static/css/style.css[m
[1m+++ b/src/main/resources/static/css/style.css[m
[36m@@ -1,3 +1,13 @@[m
[32m+[m[32m@import url("https://fonts.googleapis.com/css2?family=Manrope:wght@200;300;400;500;600;700;800&display=swap");[m
[32m+[m[32m@import url("https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700;800&family=Roboto:wght@100;300;400;500;700;900&display=swap");[m
[32m+[m[32m@import url('https://fonts.googleapis.com/css2?family=Lexend+Deca:wght@100..900&display=swap');[m
[32m+[m
[32m+[m[32m:root{[m
[32m+[m[32m    --color-primary: #DA251A;[m
[32m+[m[32m    --font-primary: "Roboto", sans-serif;[m
[32m+[m[32m    --font-secondary: "Manrope", sans-serif;[m
[32m+[m[32m}[m
[32m+[m
 * {[m
     box-sizing: border-box;[m
     margin: 0;[m
[36m@@ -6,12 +16,12 @@[m
 }[m
 [m
 a {[m
[31m-    color: var(--black);[m
[32m+[m[32m    color: #03041C;[m
     text-decoration: none;[m
     outline: none;[m
 }[m
 a:hover {[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
 }[m
 ul {[m
     padding: 0;[m
[36m@@ -71,7 +81,7 @@[m [mbody::before {[m
     text-align: center;[m
     line-height: 46px;[m
     font-size: 16px;[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
     left: 0;[m
     top: 0;[m
     height: 46px;[m
[36m@@ -81,7 +91,7 @@[m [mbody::before {[m
     z-index: 1;[m
     -webkit-transition: all 200ms linear;[m
     transition: all 200ms linear;[m
[31m-    border: 0px solid var(--themePrimary);[m
[32m+[m[32m    border: 0px solid var(--color-primary);[m
     box-shadow: none;[m
     border-radius: 50% !important;[m
     border-radius: 5px;[m
[36m@@ -90,7 +100,7 @@[m [mbody::before {[m
 .progress-wrap:hover::after {[m
     opacity: 1;[m
     content: '\f062';[m
[31m-    border: 0px solid var(--themePrimary);[m
[32m+[m[32m    border: 0px solid var(--color-primary);[m
     font-weight: 300;[m
 }[m
 .progress-wrap::before {[m
[36m@@ -101,7 +111,7 @@[m [mbody::before {[m
     line-height: 46px;[m
     font-size: 16px;[m
     opacity: 0;[m
[31m-    background: var(--themePrimary);[m
[32m+[m[32m    background: var(--color-primary);[m
     -webkit-background-clip: text;[m
     -webkit-text-fill-color: transparent;[m
     left: 0;[m
[36m@@ -122,12 +132,12 @@[m [mbody::before {[m
     fill: none;[m
 }[m
 .progress-wrap svg {[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
     border-radius: 50%;[m
     background: #fff;[m
 }[m
 .progress-wrap svg.progress-circle path {[m
[31m-    stroke: var(--themePrimary);[m
[32m+[m[32m    stroke: var(--color-primary);[m
     stroke-width: 0px;[m
     box-sizing:border-box;[m
     -webkit-transition: all 200ms linear;[m
[36m@@ -300,9 +310,9 @@[m [mbody::before {[m
 }[m
 [m
 .tmp-btn.btn-primary {[m
[31m-    background: var(--themePrimary)!important;[m
[32m+[m[32m    background: var(--color-primary)!important;[m
     border: none;[m
[31m-    background-color: var(--themePrimary);[m
[32m+[m[32m    background-color: var(--color-primary);[m
     background-image: linear-gradient(315deg, #E42032 0%, #E42032 74%);[m
     border: none;[m
     z-index: 1;[m
[36m@@ -335,10 +345,10 @@[m [mbody::before {[m
     font-size: 13px;[m
     font-weight: bold;[m
     letter-spacing: 0.05rem;[m
[31m-    border: 1px solid var(--black)[m
[32m+[m[32m    border: 1px solid #0E1822;[m
     padding: 0.6rem 2.0rem;[m
     background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 531.28 200'%3E%3Cdefs%3E%3Cstyle%3E .shape %7B fill: %23FF4655 /* fill: %230E1822; */ %7D %3C/style%3E%3C/defs%3E%3Cg id='Layer_2' data-name='Layer 2'%3E%3Cg id='Layer_1-2' data-name='Layer 1'%3E%3Cpolygon class='shape' points='415.81 200 0 200 115.47 0 531.28 0 415.81 200' /%3E%3C/g%3E%3C/g%3E%3C/svg%3E%0A");[m
[31m-    background-color: var(--themePrimary);[m
[32m+[m[32m    background-color: var(--color-primary);[m
     background-size: 200%;[m
     background-position: 200%;[m
     background-repeat: no-repeat;[m
[36m@@ -357,7 +367,7 @@[m [mbody::before {[m
 .primary-button:before {[m
     content: "";[m
     position: absolute;[m
[31m-    background-color: var(--black)[m
[32m+[m[32m    background-color: #0E1822;[m
     width: 0.2rem;[m
     height: 0.2rem;[m
     top: -1px;[m
[36m@@ -397,7 +407,7 @@[m [mbody::before {[m
     height: 50%;[m
     left: -0.3em;[m
     top: -0.3em;[m
[31m-    border: 1px solid var(--black)[m
[32m+[m[32m    border: 1px solid #0E1822;[m
     border-bottom: 0px;[m
 }[m
 [m
[36m@@ -408,14 +418,14 @@[m [mbody::before {[m
     height: 50%;[m
     left: -0.3em;[m
     bottom: -0.3em;[m
[31m-    border: 1px solid var(--black)[m
[32m+[m[32m    border: 1px solid #0E1822;[m
     border-top: 0px;[m
     /* opacity: 0.3; */[m
     z-index: 0;[m
 }[m
 [m
 .shape {[m
[31m-    fill: var(--black)[m
[32m+[m[32m    fill: #0E1822;[m
 }[m
 [m
 [m
[36m@@ -440,8 +450,8 @@[m [mbody::before {[m
 ;[m
     align-items: center;[m
     justify-content: space-between;[m
[31m-    border-left: 7px solid var(--themePrimary);[m
[31m-    border-right: 7px solid var(--themePrimary);[m
[32m+[m[32m    border-left: 7px solid var(--color-primary);[m
[32m+[m[32m    border-right: 7px solid var(--color-primary);[m
 }[m
 [m
 .logo-md-sm-device {[m
[36m@@ -479,17 +489,17 @@[m [mul li {[m
 }[m
 [m
 nav ul li a.nav-link {[m
[31m-    color: var(--black);[m
[32m+[m[32m    color: #03041c;[m
     font-weight: 700;[m
     padding: 0 1rem;[m
 }[m
 [m
 nav ul li.has-dropdown a.nav-link {[m
     /*padding: 31px 15px !important;*/[m
[31m-    color: var(--black) !important;[m
[32m+[m[32m    color: #03041c !important;[m
 }[m
 .tmp-header-area-start .has-dropdown.menu-item-open > a.nav-link {[m
[31m-    color: var(--themePrimary) !important;[m
[32m+[m[32m    color: var(--color-primary) !important;[m
 }[m
 [m
 nav ul li.has-dropdown a.nav-link::before {[m
[36m@@ -593,7 +603,7 @@[m [mnav ul li.has-dropdown .submenu li a {[m
     right: 20px;[m
     opacity: 0;[m
     transition: 0.2s;[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
 }[m
 [m
 .has-dropdown .submenu li:hover::after {[m
[36m@@ -609,7 +619,7 @@[m [mnav ul li.has-dropdown .submenu li::after {[m
 }[m
 [m
 .has-dropdown .submenu li:hover{[m
[31m-    background-color: var(--themePrimary);[m
[32m+[m[32m    background-color: var(--color-primary);[m
     color: white;[m
 }[m
 [m
[36m@@ -676,6 +686,12 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
     cursor: pointer;[m
 }[m
 [m
[32m+[m[32m.header-one .actions-area > .lang-picker {[m
[32m+[m[32m    padding-left: 25px;[m
[32m+[m[32m    border-left: 1px solid rgba(31, 31, 31, 0.2274509804);[m
[32m+[m[32m    margin-left: 15px;[m
[32m+[m[32m}[m
[32m+[m
 #side-hide.show {[m
     right: 0;[m
 }[m
[36m@@ -718,7 +734,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 }[m
 [m
 #side-hide .top-area .close-icon-area #close-slide__main i {[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
 }[m
 [m
 #side-hide .body {[m
[36m@@ -747,7 +763,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
     height: 45px;[m
     width: 45px;[m
     padding: 15px;[m
[31m-    background: var(--themePrimary);[m
[32m+[m[32m    background: var(--color-primary);[m
     display: flex;[m
     align-items: center;[m
     color: #fff;[m
[36m@@ -758,7 +774,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 [m
 .short-contact-area-side-collups .single-contact-information-side .information span {[m
     display: block;[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
     text-transform: uppercase;[m
     font-size: 15px;[m
     margin-bottom: 0;[m
[36m@@ -801,7 +817,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
     width: 40px;[m
     line-height: 40px;[m
     border-radius: 5px;[m
[31m-    background-color: --neutralDark;[m
[32m+[m[32m    background-color: #1D1E33;[m
     text-align: center;[m
     transform: scale(1);[m
     transition: 0.5s;[m
[36m@@ -1039,7 +1055,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 [m
 .mySwiper-banner-one .swiper-button-next:hover::after,[m
 .mySwiper-banner-one .swiper-button-prev:hover::after {[m
[31m-    background: var(--themePrimary);[m
[32m+[m[32m    background: var(--color-primary);[m
     color: #fff;[m
     transform: scale(1.1);[m
     border: 1px solid transparent;[m
[36m@@ -1069,7 +1085,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 .about-area.about-style-one .about-thumbnails .thumbnail .square {[m
     height: 30px;[m
     width: 30px;[m
[31m-    background-color: var(--themePrimary);[m
[32m+[m[32m    background-color: var(--color-primary);[m
     position: absolute;[m
     bottom: 50px;[m
     right: 190px;[m
[36m@@ -1097,7 +1113,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 .section-head .section-sub-title {[m
     font-size: 16px;[m
     font-weight: 700;[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
     text-transform: uppercase;[m
     margin-bottom: 5px;[m
     font-family: var(--font-secondary);[m
[36m@@ -1118,7 +1134,15 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
     font-weight: 700;[m
 }[m
 [m
[31m-[m
[32m+[m[32m.section-head .title {[m
[32m+[m[32m    color: #03041c;[m
[32m+[m[32m    font-size: 36px;[m
[32m+[m[32m    line-height: 45px;[m
[32m+[m[32m    margin-bottom: 0;[m
[32m+[m[32m    font-weight: 800;[m
[32m+[m[32m    margin-bottom: 0!important;[m
[32m+[m[32m    font-family: var(--font-secondary);[m
[32m+[m[32m}[m
 [m
 .section-head.section-head-one-side {[m
     padding-bottom: 22px;[m
[36m@@ -1182,7 +1206,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
     line-height: 30px;[m
     font-weight: 800;[m
     font-family: var(--font-secondary);[m
[31m-    color: var(--black);[m
[32m+[m[32m    color: #03041C;[m
 }[m
 [m
 .bg_image {[m
[36m@@ -1212,7 +1236,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 .section-head .section-sub-title {[m
     font-size: 16px;[m
     font-weight: 700;[m
[31m-    color: var(--themePrimary);[m
[32m+[m[32m    color: var(--color-primary);[m
     text-transform: uppercase;[m
     margin-bottom: 5px;[m
     font-family: var(--font-secondary);[m
[36m@@ -1246,14 +1270,14 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 [m
 .single-services .services-inner a .title {[m
     transition: 0.3s;[m
[31m-    color: var(--black);[m
[32m+[m[32m    color: #03041c;[m
     font-size: 20px;[m
     line-height: 15px;[m
 }[m
 [m
 .single-services .services-inner a .title {[m
     transition: 0.3s;[m
[31m-    color: var(--black);[m
[32m+[m[32m    color: #03041c;[m
     font-size: 20px;[m
     line-height: 15px;[m
 }[m
[36m@@ -1263,7 +1287,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
     height: 45px;[m
     width: 45px;[m
     line-height: 45px;[m
[31m-    border: 1px solid var(--black);[m
[32m+[m[32m    border: 1px solid #03041C;[m
     text-align: center;[m
     border-radius: 50%;[m
 }[m
[36m@@ -1273,7 +1297,7 @@[m [mnav ul li.has-dropdown:hover .submenu {[m
 }[m
 [m
 .single-services.service-style-one .services-inner .services-content .angle-roted:hover {[m
[31m-    background: var(--themePrimary);[m
[32m+[m[32m    background: var(--color-primary);[m
     border: 1px solid transparent;[m
     color: #fff;[m
     transform: scale(1.2) translateY(-5px);[m
[36m@@ -1310,7 +1334,7 @@[m [mnav ul li.ha