<template>
  <div>欢迎光临 {{ nickname }}</div>
  <q-btn @click="logout">退出</q-btn>
  <div class="page">
    <CosUploader label="上传" style="width: 40vw"/>
  </div>
</template>

<script>
import {useStore} from 'vuex';
import {computed} from 'vue';
import CosUploader from '../../composables/useCosUploader.js';

export default {
  name: 'Index',
  components: {CosUploader},
  setup() {
    const store = useStore();
    return {
      nickname: computed(() => store.state.user.currentUser.nickname),
      logout: () =>
          store.dispatch('user/logout').then(() => window.location.reload())
    };
  }
};
</script>

<style scoped></style>