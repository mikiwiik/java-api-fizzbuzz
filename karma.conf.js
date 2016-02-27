module.exports = function (config) {
    config.set({

        basePath: './',

        files: [
            // Libs
            'src/main/webapp/js/lib/angular.js',
            'src/test/js/lib/angular-mocks.js',

            // App
            'src/main/webapp/js/tester/*.js',

            // Tests
            'src/test/js/*.js'
        ],
        autoWatch: true,

        frameworks: ['jasmine'],

        browsers: ['Chrome'],

        plugins: [
            'karma-chrome-launcher',
            'karma-jasmine',
            'karma-junit-reporter'
        ],

        junitReporter: {
            outputFile: 'test_out/unit.xml',
            suite: 'unit'
        }

    });
};
