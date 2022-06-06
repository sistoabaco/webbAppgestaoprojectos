<template>
  <div class="flex flex-col space-y-2">
    <span v-if="label" id="label" class="flex flex-row items-center"
      >{{ label }}
      <strong v-if="required" class="text-red-500 ml-1">*</strong></span
    >
    <input
      v-model="inputValue"
      class="
        w-full
        py-2
        px-2
        border border-gray-200
        rounded-sm
        focus:outline-none focus:border-indigo-500
      "
      :type="type"
      :min="min"
      :max="max"
      :placeholder="placeholder"
      :disabled="disabled"
      :class="{ 'bg-gray-100 select-none': disabled }"
      @blur="$emit('blur', inputValue)"
      @focus="$emit('focus', inputValue)"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent } from '@nuxtjs/composition-api'

export default defineComponent({
  name: 'TextInput',
  props: {
    label: {
      type: String,
      default: '',
    },
    value: {
      type: [Number, String],
      default: '',
    },
    placeholder: {
      type: String,
      default: 'Placeholder',
    },
    type: {
      type: String,
      default: 'text',
    },
    disabled: {
      type: Boolean,
      default: false,
    },
    required: {
      type: Boolean,
      default: false,
    },
    min: {
      type: Number,
      default: 0,
    },
    max: {
      type: Number,
      default: null,
    },
  },
  computed: {
    inputValue: {
      get(): any {
        return this.value
      },
      set(value: any) {
        this.$emit('input', value)
      },
    },
  },
})
</script>
