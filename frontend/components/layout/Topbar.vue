<template>
  <nav>
    <div class="flex justify-between items-center p-6 h-16 bg-red-500">
      <a
        id="bv-logo"
        class="text-xl text-white font-semibold uppercase"
        href="#"
      >
        Caritas
      </a>
      <div class="flex items-center">
        <a
          id="notification-icon"
          class="text-gray-600 hover:text-gray-500 mr-6"
          href="#"
        >
          <BellIcon />
        </a>
        <div class="flex items-center">
          <div id="user-description-wrapper" class="hidden lg:block mr-3">
            <p id="user-name" class="text-sm text-white">Cassimo Duarte</p>
            <p id="user-role" class="text-sm text-gray-400">Developer</p>
          </div>
          <div class="mr-2">
            <img
              id="user-avatar"
              class="w-10 h-10 rounded-full object-cover object-right"
              src="https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-1.2.1&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=1050&amp;q=80"
              alt=""
            />
          </div>
          <span>
            <ArrowDownIcon />
          </span>
        </div>
      </div>
    </div>
  </nav>
</template>

<script lang="ts">
import { defineComponent } from '@nuxtjs/composition-api'
import BellIcon from '~/assets/icons/bell.vue'
import ArrowDownIcon from '~/assets/icons/arrow-down.vue'
export default ({
  name: 'Header',
  components: { ArrowDownIcon, BellIcon },
  computed: {
    userDetails(): any {
      //return this.$store.state.auth.user.js
    },
  },
})
</script>
