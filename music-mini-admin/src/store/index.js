import {createLogger, createStore} from 'vuex';

import user from './modules/user.js';
import setting from './modules/setting.js';

const debug = process.env.NODE_ENV !== 'production';

export default createStore({
    modules: {
        user,
        setting
    },
    plugins: debug ? [createLogger()] : []
});