FilePond.registerPlugin(
    FilePondPluginImagePreview,
    FilePondPluginImageEdit,
    FilePondPluginFileRename,
    FilePondPluginImageResize,
    FilePondPluginImageCrop,
    FilePondPluginImageExifOrientation
);

$('.my-pond').filepond();


FilePond.create(document.querySelector('input'), {
    // default crop aspect ratio
    imageCropAspectRatio: 1,

    // resize to width of 200
    imageResizeTargetWidth: 200,

    // open editor on image drop
    imageEditInstantEdit: true,

    // configure Doka
    imageEditEditor: Doka.create({
        // Doka.js options here ...

        cropAspectRatioOptions: [
            {
                label: 'Free',
                value: null,
            },
            {
                label: 'Portrait',
                value: 1.25,
            },
            {
                label: 'Square',
                value: 1,
            },
            {
                label: 'Landscape',
                value: 0.75,
            },
        ],
    }),
});