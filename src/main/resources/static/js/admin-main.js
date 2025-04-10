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


    document.querySelectorAll('.btn-delete-carousel').forEach(button => {
        button.addEventListener('click', function() {
            var itemIdToDelete = this.getAttribute('data-id');
            var image_url = this.getAttribute("data-image_url");
            $("#delete-carousel-action-confirmation-submit-button").attr("data-id", itemIdToDelete);
            $("#delete-carousel-action-confirmation-submit-button").attr("data-image_url", image_url);
        });
    });

    $('#delete-carousel').attr("data-toggle", "modal").attr("data-target", "#delete-carousel-action-confirmation");
    $('#delete-carousel-action-confirmation-submit-button').attr("name", $("#delete-carousel").attr("name"));
    $("#delete-carousel").attr("name", "");
    if($("#delete-carousel").attr("type") == "submit")
        $("#delete-carousel").attr("type", "button");

    $('#delete-carousel-action-confirmation-submit-button').bind('click', function () {
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




