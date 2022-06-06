<template>
  <div>
    <div :class="addContainer" class="bg-white p-4">
      <h1 class="text-xl">
        <slot name="title">
          {{ title }}
        </slot>
      </h1>
      <p :class="padded ? 'mb-5' : ''" class="w-full text-sm text-gray-400">
        {{ subTitle }}
      </p>
      <slot></slot>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from '@nuxtjs/composition-api'

export default ({
  name: 'Page',
  props: {
    title: {
      type: String,
      default: '',
    },
    subTitle: {
      type: String,
      default: '',
    },
    padded: {
      type: Boolean,
      default: true,
    },
  },
  data: () => ({
    windowSize: null,
  }),
  computed: {
    addContainer(): object {
      return (this as any).windowSize > 1280
        ? { container: true, 'mx-auto px-2 md:px-4 xl:px-2 xxl:px-4': true }
        : { 'px-2 md:px-4 xl:px-4 xxl:px-4': true }
    },
  },
})
</script>
