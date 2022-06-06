<template>
  <div
    class="
      modal-backdrop
      backdrop-filter backdrop-blur-sm
      fixed
      top-0
      left-0
      inset-0
      flex
      items-center
      justify-center
      z-50
    "
  >
    <div
      class="relative py-6 rounded-lg shadow bg-white overflow-hidden"
      :style="setModalSize"
    >
      <div
        v-if="busy"
        class="
          absolute
          z-10
          inset-0
          flex
          items-center
          justify-center
          bg-white bg-opacity-75
        "
      >
        loading...
      </div>
      <div
        class="absolute top-6 right-4 cursor-pointer"
        @click="$emit('close')"
      >
        <close-icon class="w-4 h-4 fill-current hover:text-gray-300" />
      </div>
      <div class="flex flex-col divide-gray-100 divide-y-2">
        <div class="flex flex-row justify-between mb-4 px-8">
          <div class="flex flex-col">
            <div class="flex flex-row items-center space-x-2">
              <h3 class="font-normal text-lg">{{ title }}</h3>
            </div>
            <p class="text-xs text-gray-400">{{ description }}</p>
          </div>
        </div>
        <div class="px-8 py-4">
          <slot />
        </div>
        <div class="flex flex-wrap w-full justify-end items-center pt-4 px-8">
          <slot name="actions" />
        </div>
      </div>
    </div>
  </div>
</template>
<script lang="ts">
import Vue from 'vue'
import CloseIcon from '~/assets/icons/CloseIcon.vue'
export default Vue.extend({
  name: 'Modal',
  components: {
    CloseIcon,
  },
  props: {
    icon: { type: String, default: null },
    busy: { type: Boolean, default: false },
    disabled: { type: Boolean, default: false },
    title: { type: String, required: true },
    description: { type: String, default: null },
    size: { type: String, default: 'md' },
    buttonLabel: { type: String, default: 'Button Label' },
    buttonVariant: { type: String, default: 'ultramarine' },
    loading: { type: Boolean, default: false },
  },
  computed: {
    setModalSize(this: any) {
      const returnSize = {
        'max-width': '',
      }
      if (this.size === 'md') {
        returnSize['max-width'] = '484px'
      }
      if (this.size === 'lg') {
        returnSize['max-width'] = '600px'
      }
      if (this.size === 'xl') {
        returnSize['max-width'] = '768px'
      }
      return returnSize
    },
  },
})
</script>

<style scoped>
.modal-backdrop {
  background-color: rgba(0, 0, 40, 0.5);
}
</style>
