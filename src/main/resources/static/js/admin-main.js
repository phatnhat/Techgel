FilePond.registerPlugin(
    FilePondPluginImagePreview,
    FilePondPluginImageEdit,
    FilePondPluginFileRename,
    FilePondPluginImageResize,
    FilePondPluginImageCrop,
    FilePondPluginImageExifOrientation,
    FilePondPluginFileValidateType,
);

$('.filepond').filepond();

$(".alert").fadeTo(5000, 500).slideUp(500, function(){
    $(".alert").slideUp(500);
});

$(document).ready(function() {
    function FilePondDelete(fileUrl) {
        fetch(`/api/files/${fileUrl}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) {
                load();
            } else {
                console.log('Delete Failed');
                return false;
            }
        })
        .catch(err => err);
    }

    const eProfileImageFilepond = FilePond.create(document.querySelector('#eprofile-image-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
                    formData.append('type', 'eprofile-image');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
        new Promise((resolve, reject) => {
            resolve(type);
        })
    });
    let eProfileFileFilepond = FilePond.create(document.querySelector('#eprofile-file-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#eprofile-file-filepond').parent().attr("data-id"));
                    formData.append('type', 'eprofile-file');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='file_url']").val(response);
                    return response;
                },
                oncomplete: (response) => {
                    console.log(response);
                }
            },
        },
        acceptedFileTypes: ['application/pdf'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file PDF',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file PDF',
        labelIdle: 'Kéo thả file PDF hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const eprofile_form = document.querySelector('#eprofile-form');
    if(eprofile_form){
        eprofile_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            $('.loading-wrapper').show();

            try{
                await Promise.all([
                    eProfileImageFilepond.processFiles(),
                    eProfileFileFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['image-delete'] ? form.elements['image-delete'].checked : false;
                const isFileDelete = form.elements['file-delete'] ? form.elements['file-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['image_url'].value) : Promise.resolve(),
                    isFileDelete ? FilePondDelete(form.elements['file_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }

    const carouselImageFilepond = FilePond.create(document.querySelector('#carousel-image-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#carousel-image-filepond').parent().attr("data-id"));
                    formData.append('type', 'carousel-image');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const carousel_form = document.querySelector('#carousel-form');
    if(carousel_form){
        carousel_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    carouselImageFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['image-delete'] ? form.elements['image-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['image_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }


    const homeAboutUsImageFilepond1 = FilePond.create(document.querySelector('#homeaboutus-image-filepond-1'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#homeaboutus-image-filepond-1').parent().attr("data-id"));
                    formData.append('type', 'homeaboutus-image-1');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url_1']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const homeAboutUsImageFilepond2 = FilePond.create(document.querySelector('#homeaboutus-image-filepond-2'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#homeaboutus-image-filepond-2').parent().attr("data-id"));
                    formData.append('type', 'homeaboutus-image-2');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url_2']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const homeAboutUsImageFilepond3 = FilePond.create(document.querySelector('#homeaboutus-image-filepond-3'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#homeaboutus-image-filepond-3').parent().attr("data-id"));
                    formData.append('type', 'homeaboutus-image-3');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url_3']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const homeaboutus_form = document.querySelector('#homeAboutUs-form');
    if(homeaboutus_form){
        homeaboutus_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    homeAboutUsImageFilepond1.processFiles(),
                    homeAboutUsImageFilepond2.processFiles(),
                    homeAboutUsImageFilepond3.processFiles()
                ]);

                const form = e.target;

                const isImage1Delete = form.elements['image-delete-1'] ? form.elements['image-delete-1'].checked : false;
                const isImage2Delete = form.elements['image-delete-2'] ? form.elements['image-delete-2'].checked : false;
                const isImage3Delete = form.elements['image-delete-3'] ? form.elements['image-delete-3'].checked : false;

                await Promise.all([
                    isImage1Delete ? FilePondDelete(form.elements['image_url_1'].value) : Promise.resolve(),
                    isImage2Delete ? FilePondDelete(form.elements['image_url_2'].value) : Promise.resolve(),
                    isImage3Delete ? FilePondDelete(form.elements['image_url_3'].value) : Promise.resolve(),
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }


    const AboutUsOverviewIntroduceImageFilepond = FilePond.create(document.querySelector('#aboutUsIntroduce-image-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#aboutUsIntroduce-image-filepond').parent().attr("data-id"));
                    formData.append('type', 'aboutUsIntroduce-image');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const aboutUsIntroduce_form = document.querySelector('#aboutUsIntroduce-form');
    if(aboutUsIntroduce_form){
        aboutUsIntroduce_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    AboutUsOverviewIntroduceImageFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['image-delete'] ? form.elements['image-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['image_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }


    const AboutUsOverviewTestimonialImageFilepond = FilePond.create(document.querySelector('#aboutUsTestimonial-image-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#aboutUsTestimonial-image-filepond').parent().attr("data-id"));
                    formData.append('type', 'aboutUsTestimonial-image');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='thumbnail_url']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const aboutUsTestimonial_form = document.querySelector('#testimonialItems-form');
    if(aboutUsTestimonial_form){
        aboutUsTestimonial_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    AboutUsOverviewTestimonialImageFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['image-delete'] ? form.elements['image-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['thumbnail_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }


    let organizationalChartFileFilepond = FilePond.create(document.querySelector('#organizational-chart-file-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#organizational-chart-file-filepond').parent().attr("data-id"));
                    formData.append('type', 'organizational-chart-file');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='file_url']").val(response);
                    return response;
                },
                oncomplete: (response) => {
                    console.log(response);
                }
            },
        },
        acceptedFileTypes: ['application/pdf'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file PDF',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file PDF',
        labelIdle: 'Kéo thả file PDF hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const aboutUsOrganizationalChart_form = document.querySelector('#aboutUsOrganizationalChart-form');
    if(aboutUsOrganizationalChart_form){
        aboutUsOrganizationalChart_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    organizationalChartFileFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['file-delete'] ? form.elements['file-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['file_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }


    const AboutUsOrganizationalChartItemsImageFilepond = FilePond.create(document.querySelector('#aboutUsOrganizationalChartItems-image-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#aboutUsOrganizationalChartItems-image-filepond').parent().attr("data-id"));
                    formData.append('type', 'aboutUsOrganizationalChartItems-image');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const organizationalChartItems_form = document.querySelector('#organizationalChartItems-form');
    if(organizationalChartItems_form){
        organizationalChartItems_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    AboutUsOrganizationalChartItemsImageFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['image-delete'] ? form.elements['image-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['image_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }


    const AboutUsLicenseCertificateItemsImageFilepond = FilePond.create(document.querySelector('#aboutUsLicenseCertificateItems-image-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#aboutUsLicenseCertificateItems-image-filepond').parent().attr("data-id"));
                    formData.append('type', 'aboutUsLicenseCertificateItems-image');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const aboutUsLicenseCertificateItems_form = document.querySelector('#aboutUsLicenseCertificateItems-form');
    if(aboutUsLicenseCertificateItems_form){
        aboutUsLicenseCertificateItems_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    AboutUsLicenseCertificateItemsImageFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['image-delete'] ? form.elements['image-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['image_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }

    const AboutUsClientPartnerItemsImageFilepond = FilePond.create(document.querySelector('#aboutUsClientPartnerItems-image-filepond'), {
        instantUpload: false,
        server: {
            url: '/api/files',
            process: {
                url: '/upload',
                method: 'POST',
                ondata: (formData) => {
                    formData.append('id', $('#aboutUsClientPartnerItems-image-filepond').parent().attr("data-id"));
                    formData.append('type', 'aboutUsClientPartnerItems-image');
                    return formData;
                },
                onload: (response) => {
                    $("input[name='image_url']").val(response);
                    return response;
                }
            },
        },
        acceptedFileTypes: ['image/*'],
        fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
        labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
        labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
        fileValidateTypeDetectType: (source, type) =>
            new Promise((resolve, reject) => {
                resolve(type);
            })
    });
    const aboutUsClientPartnerItems_form = document.querySelector('#aboutUsClientPartnerItems-form');
    if(aboutUsClientPartnerItems_form){
        aboutUsClientPartnerItems_form.addEventListener('submit', async (e) => {
            e.preventDefault();

            try{
                $('.loading-wrapper').show();

                await Promise.all([
                    AboutUsClientPartnerItemsImageFilepond.processFiles()
                ]);

                const form = e.target;

                const isImageDelete = form.elements['image-delete'] ? form.elements['image-delete'].checked : false;

                await Promise.all([
                    isImageDelete ? FilePondDelete(form.elements['image_url'].value) : Promise.resolve()
                ]);

                const actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = document.activeElement.value;
                form.appendChild(actionInput);

                form.submit();
            }catch(error){}

            $('.loading-wrapper').hide();
        });
    }



    document.querySelectorAll('.btn-delete-carousel').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var image_url = this.getAttribute("data-image_url");
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-image_url", image_url);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });
    document.querySelectorAll('.btn-delete-statistic-items').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });
    document.querySelectorAll('.btn-delete-testimonial-items').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var thumbnail_url = this.getAttribute("data-thumbnail_url");
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-thumbnail_url", thumbnail_url);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });
    document.querySelectorAll('.btn-delete-organizational-chart-items').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var image_url = this.getAttribute("data-image_url");
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-image_url", image_url);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });
    document.querySelectorAll('.btn-delete-license-certificate').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });
    document.querySelectorAll('.btn-delete-license-certificate-items').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var parentId = this.getAttribute("data-parentId");
            var image_url = this.getAttribute("data-image_url");
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-parentId", parentId);
            $("#delete-action-confirmation-submit-button").attr("data-image_url", image_url);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });
    document.querySelectorAll('.btn-delete-client-partner').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });
    document.querySelectorAll('.btn-delete-client-partner-items').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var parentId = this.getAttribute("data-parentId");
            var image_url = this.getAttribute("data-image_url");
            var type = this.getAttribute("data-type");
            $("#delete-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-action-confirmation-submit-button").attr("data-parentId", parentId);
            $("#delete-action-confirmation-submit-button").attr("data-image_url", image_url);
            $("#delete-action-confirmation-submit-button").attr("data-type", type);
        });
    });


    $('#delete-action-confirmation-submit-button').bind('click', function () {
        let type = $(this).attr('data-type');
        console.log(type)
        if(type == 'carousel'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');
                let form = new FormData()
                form.append("image_url", $(this).attr("data-image_url"))

                FilePondDelete($(this).attr("data-image_url"))

                fetch(`/webadmin/home/carousel/delete/${id}`, {
                    method: 'DELETE',
                    body: form
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/webadmin/home/carousel';
                        }
                    });

                $('#delete-carousel-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
        else if(type == 'statistic-items'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');
                let form = new FormData()
                form.append("image_url", $(this).attr("data-image_url"))

                fetch(`/webadmin/home/statistic-items/delete/${id}`, {
                    method: 'DELETE',
                    body: form
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/webadmin/home/statistic';
                        }
                    });

                $('#delete-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
        else if(type == 'testimonial-items'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');
                let form = new FormData()
                form.append("thumbnail_url", $(this).attr("data-thumbnail_url"))

                FilePondDelete($(this).attr("data-thumbnail_url"))

                fetch(`/webadmin/about-us/overview/testimonial-items/delete/${id}`, {
                    method: 'DELETE',
                    body: form
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/webadmin/about-us/overview/testimonial';
                        }
                    });

                $('#delete-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
        else if(type == 'organizational-chart-items'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');
                let form = new FormData()
                form.append("image_url", $(this).attr("data-image_url"))

                FilePondDelete($(this).attr("data-image_url"))

                fetch(`/webadmin/about-us/organizational-chart-items/delete/${id}`, {
                    method: 'DELETE',
                    body: form
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/webadmin/about-us/organizational-chart';
                        }
                    });

                $('#delete-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
        else if(type == 'license-certificate'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');

                fetch(`/webadmin/about-us/licenses-certificates/delete/${id}`, {
                    method: 'DELETE',
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/webadmin/about-us/licenses-certificates';
                        }
                    });

                $('#delete-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
        else if(type == 'license-certificate-items'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');
                let parentId = $(this).attr('data-parentId');
                let form = new FormData()
                form.append("image_url", $(this).attr("data-image_url"))

                FilePondDelete($(this).attr("data-image_url"))

                fetch(`/webadmin/about-us/licenses-certificates-items/delete/${id}`, {
                    method: 'DELETE',
                    body: form
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = `/webadmin/about-us/licenses-certificates-items?id=${parentId}`;
                        }
                    });

                $('#delete-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
        else if(type == 'client-partner'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');

                fetch(`/webadmin/about-us/clients-partners/delete/${id}`, {
                    method: 'DELETE',
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/webadmin/about-us/clients-partners';
                        }
                    });

                $('#delete-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
        else if(type == 'client-partner-items'){
            try{
                $('.loading-wrapper').show();

                let id = $(this).attr('data-id');
                let parentId = $(this).attr('data-parentId');
                let form = new FormData()
                form.append("image_url", $(this).attr("data-image_url"))

                FilePondDelete($(this).attr("data-image_url"))

                fetch(`/webadmin/about-us/clients-partners-items/delete/${id}`, {
                    method: 'DELETE',
                    body: form
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = `/webadmin/about-us/clients-partners-items?id=${parentId}`;
                        }
                    });

                $('#delete-action-confirmation').modal('toggle');
            }catch (error) {}

            $('.loading-wrapper').hide();

            return false;
        }
    });

    // try{
    //     if(eProfileEditImageUrl){
    //         eProfileImageFilepond = FilePond.create(document.querySelector('#eprofile-image-filepond'), {
    //             acceptedFileTypes: ['image/*'],
    //             chunkUploads: true,
    //             chunkSize: '5MB',
    //         });
    //         eProfileImageFilepond.addFile(`/api/drive-proxy?id=${eProfileEditImageUrl}&mediaType=image`);
    //         eProfileImageFilepond.on('removefile', (error, file) => {
    //             if (error) return;
    //
    //             const formData = new FormData();
    //             formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
    //             formData.append('type', 'eprofile-image');
    //             fetch(`/api/files/${eProfileEditImageUrl}`, {
    //                 method: 'DELETE',
    //                 body: formData
    //             })
    //                 .then(response => {
    //                     if (response.ok) {
    //                         console.log("Ok");
    //                         eProfileImageFilepond = FilePond.create(document.querySelector('#eprofile-image-filepond'), {
    //                             server: {
    //                                 url: '/api/files',
    //                                 process: {
    //                                     url: '/upload',
    //                                     method: 'POST',
    //                                     ondata: (formData) => {
    //                                         formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
    //                                         formData.append('type', 'eprofile-image');
    //                                         return formData;
    //                                     },
    //                                     onload: (response) => {
    //                                         return response;
    //                                     }
    //                                 },
    //                                 revert: (fileUrl, load, error) => {
    //                                     const formData = new FormData();
    //                                     formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
    //                                     formData.append('type', 'eprofile-image');
    //
    //                                     const match = fileUrl.match(/\/file\/d\/([^\/]+)/);
    //                                     const fileId = match ? match[1] : null;
    //
    //                                     fetch(`/api/files/${fileId}`, {
    //                                         method: 'DELETE',
    //                                         body: formData
    //                                     })
    //                                         .then(response => {
    //                                             if (response.ok) {
    //                                                 load();
    //                                             } else {
    //                                                 console.error('Delete failed');
    //                                             }
    //                                         })
    //                                         .catch(err => console.error(err));
    //                                 }
    //                             },
    //                             acceptedFileTypes: ['image/*'],
    //                             chunkUploads: true,
    //                             chunkSize: '5MB',
    //                             fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
    //                             labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
    //                             labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
    //                             fileValidateTypeDetectType: (source, type) =>
    //                                 new Promise((resolve, reject) => {
    //                                     resolve(type);
    //                                 })
    //                         });
    //                     } else {
    //                         console.error('Delete failed');
    //                     }
    //                 })
    //                 .catch(err => console.error(err));
    //         });
    //     }
    //     if(eProfileEditFileUrl){
    //         eProfileFileFilepond = FilePond.create(document.querySelector('#eprofile-file-filepond'), {
    //             acceptedFileTypes: ['application/pdf'],
    //         });
    //         eProfileFileFilepond.addFile(`/api/drive-proxy?id=${eProfileEditFileUrl}&mediaType=pdf`);
    //         eProfileFileFilepond.on('removefile', (error, file) => {
    //             if (error) return;
    //             const formData = new FormData();
    //             formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
    //             formData.append('type', 'eprofile-file');
    //             fetch(`/api/files/${eProfileEditFileUrl}`, {
    //                 method: 'DELETE',
    //                 body: formData
    //             })
    //                 .then(response => {
    //                     if (response.ok) {
    //                         console.log("Ok");
    //                         eProfileFileFilepond = FilePond.create(document.querySelector('#eprofile-file-filepond'), {
    //                             server: {
    //                                 url: '/api/files',
    //                                 process: {
    //                                     url: '/upload',
    //                                     method: 'POST',
    //                                     ondata: (formData) => {
    //                                         formData.append('id', $('#eprofile-file-filepond').parent().attr("data-id"));
    //                                         formData.append('type', 'eprofile-file');
    //                                         return formData;
    //                                     },
    //                                     onload: (response) => {
    //                                         return response;
    //                                     }
    //                                 },
    //                                 revert: (fileUrl, load, error) => {
    //                                     const formData = new FormData();
    //                                     formData.append('id', $('#eprofile-file-filepond').parent().attr("data-id"));
    //                                     formData.append('type', 'eprofile-file');
    //
    //                                     const match = fileUrl.match(/\/file\/d\/([^\/]+)/);
    //                                     const fileId = match ? match[1] : null;
    //
    //                                     fetch(`/api/files/${fileId}`, {
    //                                         method: 'DELETE',
    //                                         body: formData
    //                                     })
    //                                         .then(response => {
    //                                             if (response.ok) {
    //                                                 load();
    //                                             } else {
    //                                                 console.error('Delete failed');
    //                                             }
    //                                         })
    //                                         .catch(err => console.error(err));
    //                                 }
    //                             },
    //                             acceptedFileTypes: ['application/pdf'],
    //                             chunkUploads: true,
    //                             chunkSize: '5MB',
    //                             fileValidateTypeLabelExpectedTypes: 'Yêu cầu file PDF',
    //                             labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file PDF',
    //                             labelIdle: 'Kéo thả file PDF hoặc <span class="filepond--label-action">Duyệt</span>',
    //                             fileValidateTypeDetectType: (source, type) =>
    //                                 new Promise((resolve, reject) => {
    //                                     resolve(type);
    //                                 })
    //                         });
    //                     } else {
    //                         console.error('Delete failed');
    //                     }
    //                 })
    //                 .catch(err => console.error(err));
    //         });
    //     }
    // }catch (error){}
    // try{
    //     let carouselImageFilepond = FilePond.create(document.querySelector('#carousel-image-filepond'), {
    //         instantUpload: false,
    //         server: {
    //             url: '/api/files',
    //             process: {
    //                 url: '/upload',
    //                 method: 'POST',
    //                 ondata: (formData) => {
    //                     formData.append('id', $('#carousel-image-filepond').parent().attr("data-id") || null);
    //                     formData.append('type', 'carousel-image');
    //                     return formData;
    //                 },
    //                 onload: (response) => {
    //                     $("input[name='image_url']").val(response);
    //                     return response;
    //                 }
    //             },
    //             revert: (fileId, load, error) => {
    //                 const formData = new FormData();
    //                 formData.append('id', $('#carousel-image-filepond').parent().attr("data-id") || null);
    //                 formData.append('type', 'carousel-image');
    //
    //                 fetch(`/api/files/${fileId}`, {
    //                     method: 'DELETE',
    //                     body: formData
    //                 })
    //                     .then(response => {
    //                         if (response.ok) {
    //                             eProfileImageFilepond = FilePond.create(document.querySelector('#carousel-image-filepond'), {
    //                                 server: {
    //                                     url: '/api/files',
    //                                     process: {
    //                                         url: '/upload',
    //                                         method: 'POST',
    //                                         ondata: (formData) => {
    //                                             formData.append('id', $('#carousel-image-filepond').parent().attr("data-id") || null);
    //                                             formData.append('type', 'carousel-image');
    //                                             return formData;
    //                                         },
    //                                         onload: (response) => {
    //                                             $("input[name='carousel.image_url']").val(response);
    //                                             return response;
    //                                         }
    //                                     },
    //                                     revert: (fileId, load, error) => {
    //                                         const formData = new FormData();
    //                                         formData.append('id', $('#carousel-image-filepond').parent().attr("data-id") || null);
    //                                         formData.append('type', 'carousel-image');
    //
    //                                         fetch(`/api/files/${fileId}`, {
    //                                             method: 'DELETE',
    //                                             body: formData
    //                                         })
    //                                             .then(response => {
    //                                                 if (response.ok) {
    //                                                     load();
    //                                                 } else {
    //                                                     console.error('Delete failed');
    //                                                 }
    //                                             })
    //                                             .catch(err => console.error(err));
    //                                     }
    //                                 },
    //                                 acceptedFileTypes: ['image/*'],
    //                                 fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
    //                                 labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
    //                                 labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
    //                                 fileValidateTypeDetectType: (source, type) =>
    //                                     new Promise((resolve, reject) => {
    //                                         resolve(type);
    //                                     })
    //                             });
    //                             load();
    //                         } else {
    //                             console.error('Delete failed');
    //                         }
    //                     })
    //                     .catch(err => console.error(err));
    //             }
    //         },
    //         acceptedFileTypes: ['image/*'],
    //         fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
    //         labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
    //         labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
    //         fileValidateTypeDetectType: (source, type) =>
    //             new Promise((resolve, reject) => {
    //                 resolve(type);
    //             })
    //     });
    //     document.querySelector('#carousel-create-form').addEventListener('submit', async (e) => {
    //         e.preventDefault();
    //         await carouselImageFilepond.processFiles();
    //
    //         const form = e.target;
    //         const formData = new FormData(form);
    //         formData.append('image_url', $("input[name='image_url']").val());
    //         form.submit();
    //     });
    //     if(carouselEditImageUrl){
    //         carouselImageFilepond.addFile(`/api/drive-proxy?id=${carouselEditImageUrl}&mediaType=image`);
    //     }
    //     eProfileImageFilepond.on('removefile', (error, file) => {
    //         if (error) return;
    //
    //         const formData = new FormData();
    //         formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
    //         formData.append('type', 'eprofile-image');
    //         fetch(`/api/files/${eProfileEditImageUrl}`, {
    //             method: 'DELETE',
    //             body: formData
    //         })
    //             .then(response => {
    //                 if (response.ok) {
    //                     console.error('Delete success');
    //                 } else {
    //                     console.error('Delete failed');
    //                 }
    //             })
    //             .catch(err => console.error(err));
    //     });
    // }catch (error){}
});

// FilePond.create(document.querySelector('#eprofile-image-filepond'), {
//     server: {
//         url: '/api/files',
//         process: {
//             url: '/upload',
//             method: 'POST',
//             ondata: (formData) => {
//                 formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
//                 formData.append('type', 'eprofile-image');
//                 return formData;
//             },
//             onload: (response) => {
//                 return response;
//             }
//         },
//         revert: (fileUrl, load, error) => {
//             const formData = new FormData();
//             formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
//             formData.append('type', 'eprofile-image');
//
//             const match = fileUrl.match(/\/file\/d\/([^\/]+)/);
//             const fileId = match ? match[1] : null;
//
//             fetch(`/api/files/${fileId}`, {
//                 method: 'DELETE',
//                 body: formData
//             })
//                 .then(response => {
//                     if (response.ok) {
//                         load();
//                     } else {
//                         console.error('Delete failed');
//                     }
//                 })
//                 .catch(err => console.error(err));
//         }
//     },
//     acceptedFileTypes: ['image/*'],
//     chunkUploads: true,
//     chunkSize: '5MB',
//     fileValidateTypeLabelExpectedTypes: 'Yêu cầu file ảnh',
//     labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file ảnh',
//     labelIdle: 'Kéo thả file ảnh hoặc <span class="filepond--label-action">Duyệt</span>',
//     fileValidateTypeDetectType: (source, type) =>
//         new Promise((resolve, reject) => {
//             resolve(type);
//         })
// });
// FilePond.create(document.querySelector('#eprofile-file-filepond'), {
//     server: {
//         url: '/api/files',
//         process: {
//             url: '/upload',
//             method: 'POST',
//             ondata: (formData) => {
//                 formData.append('id', $('#eprofile-file-filepond').parent().attr("data-id"));
//                 formData.append('type', 'eprofile-file');
//                 return formData;
//             },
//             onload: (response) => {
//                 return response;
//             }
//         },
//         revert: (fileUrl, load, error) => {
//             const formData = new FormData();
//             formData.append('id', $('#eprofile-file-filepond').parent().attr("data-id"));
//             formData.append('type', 'eprofile-file');
//
//             const match = fileUrl.match(/\/file\/d\/([^\/]+)/);
//             const fileId = match ? match[1] : null;
//
//             fetch(`/api/files/${fileId}`, {
//                 method: 'DELETE',
//                 body: formData
//             })
//                 .then(response => {
//                     if (response.ok) {
//                         load();
//                     } else {
//                         console.error('Delete failed');
//                     }
//                 })
//                 .catch(err => console.error(err));
//         }
//     },
//     acceptedFileTypes: ['application/pdf'],
//     chunkUploads: true,
//     chunkSize: '5MB',
//     fileValidateTypeLabelExpectedTypes: 'Yêu cầu file PDF',
//     labelFileTypeNotAllowed: 'File không hợp lệ. Vui lòng chọn file PDF',
//     labelIdle: 'Kéo thả file PDF hoặc <span class="filepond--label-action">Duyệt</span>',
//     fileValidateTypeDetectType: (source, type) =>
//         new Promise((resolve, reject) => {
//             resolve(type);
//         })
// });




