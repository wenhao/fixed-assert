import gulp from 'gulp';
import _ from 'lodash';
import shell from 'gulp-shell';

const defaultConfig = {
    "image": "fixed-asset-client"
};

let conf;

setOptions(); // init

const TASK_NAME = 'buildDocker';

const task = gulp.task(TASK_NAME, ()=> {
    function bundle() {
        return shell.task([
            'docker build -t ' + conf.image + ' .'
        ]);
    }

    return bundle();
});

task.setOptions = setOptions;

export default task;

function setOptions(opts) {
    conf = _.merge({}, defaultConfig, opts)
}
