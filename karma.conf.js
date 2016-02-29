module.exports = function (config) {
    config.set({

        basePath: './',

        files: [
            // App
            'src/main/webapp/js/lib/angular.js',
            'src/main/webapp/js/common/*.js',
            'src/main/webapp/js/results/*.js',
            'src/main/webapp/js/tester/*.js',

            // Tests
            'src/test/js/lib/angular-mocks.js',
            'src/test/js/lib/jquery.js',
            'src/test/js/lib/jasmine-jquery.js',
            'src/test/js/specs/*.js'
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
