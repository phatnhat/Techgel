FilePond.registerPlugin(
    FilePondPluginImagePreview,
    FilePondPluginImageEdit,
    FilePondPluginFileRename,
    FilePondPluginImageResize,
    FilePondPluginImageCrop,
    FilePondPluginImageExifOrientation,
    FilePondPluginFileValidateType,
    FilePondPluginFileValidateSize
);

$('.filepond').filepond();

$(".alert").fadeTo(5000, 500).slideUp(500, function(){
    $(".alert").slideUp(500);
});

// const pond = FilePond.create(document.querySelector('.filepond'), {
//     server: {
//         url: 'http://localhost:8080',
//         process: {
//             url: '/api/upload',
//             method: 'POST',
//         },
//         revert: {
//             url: '/api/files/',
//             process: {
//                 method: 'DELETE',
//                 url: '/api/files'
//             },
//             onload: (response) => {
//                 console.log('File deleted:', response);
//             },
//             onerror: (response) => {
//                 console.error('Delete error:', response);
//             }
//         }
//     },
//     acceptedFileTypes: ['image/*'],
//     fileValidateTypeDetectType: (source, type) =>
//         new Promise((resolve, reject) => {
//             resolve(type);
//         })
// });


FilePond.create(document.querySelector('#eprofile-image-filepond'), {
    server: {
        url: '/api/files',
        process: {
            url: '/upload',
            method: 'POST',
            ondata: (formData) => {
                formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));
                return formData;
            },
            onload: (response) => {
                return response;
            }
        },
        revert: (uniqueFileId, load, error) => {
            const formData = new FormData();
            formData.append('id', $('#eprofile-image-filepond').parent().attr("data-id"));

            fetch(`/api/files/${uniqueFileId}`, {
                method: 'DELETE',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    load();
                } else {
                    error('Delete failed');
                }
            })
            .catch(err => error(err));
        }
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

FilePond.create(document.querySelector('#eprofile-file-filepond'), {
    server: {
        url: '/api/files',
        process: {
            url: '/upload',
            method: 'POST',
            onload: (response) => {
                return response;
            }
        },
        revert: (uniqueFileId, load, error) => {
            fetch(`/api/files/${uniqueFileId}`, {
                method: 'DELETE'
            })
                .then(response => {
                    if (response.ok) {
                        load();
                    } else {
                        error('Delete failed');
                    }
                })
                .catch(err => error(err));
        }
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

