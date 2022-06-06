<template>
  <button
    class="
      cursor-pointer
      rounded
      pb-1
      text-center
      items-center
      text-black
      shadow
    "
    :class="{ ...loadingButton, ...getVariant }"
    :style="setSize"
    @click="$emit('clicked')"
  >
    <span class="flex flex-wrap w-full justify-center items-center">
      <div v-if="icon" class="fill-current mr-2">
        <slot name="icon">
          <loading />
        </slot>
      </div>
      {{ label }}
    </span>
  </button>
</template>

<script lang="ts">
import { defineComponent } from '@nuxtjs/composition-api'
//import Loading from './Loading.vue'

export default defineComponent({
  name: 'AppButton',
  components: { //Loading 
  },
  props: {
    label: {
      type: String,
      default: '',
    },
    loading: {
      type: Boolean,
      default: false,
    },
    variant: {
      type: String,
      default: 'primary',
    },
    icon: {
      type: Boolean,
      default: false,
    },
    size: {
      type: String,
      default: '',
    },
  },
  computed: {
    getVariant() {
      const classes = {} as any
      if (this.variant === 'primary') {
        classes[`bg-${this.variant}-default hover:bg-${this.variant}-dark`] =
          true
      } else if (this.variant === 'green') {
        classes[
          `bg-${this.variant}-500 hover:bg-${this.variant}-600 transition duration-200`
        ] = true
      } else if (this.variant === 'white') {
        classes[
          `bg-${this.variant} hover:bg-gray-100 transition duration-200`
        ] = true
      } else classes[`bg-${this.variant}`] = true
      return classes
    },
    loadingButton() {
      const classes = {} as any
      if (this.loading) classes['opacity-50 cursor-not-allowed'] = true
      return classes
    },
    setSize() {
      const size = {
        height: '',
        width: '',
      }
      if (this.size === 'small') {
        size.height = '30px'
        size.width = '40px'
      } else if (this.size === 'medium') {
        size.height = '35px'
        size.width = '95px'
      } else if (this.size === 'large') {
        size.height = '40px'
        size.width = '130px'
      }
      return size
    },
  },
})
</script>
