<template>
  <div class="flex flex-col space-y-2">
    <span v-if="label" id="label" class="flex flex-row items-center"
      >{{ label
      }}<strong v-if="required" class="text-red-500 ml-1">*</strong></span
    >
    <select
      v-model="inputValue"
      :disabled="disabled"
      class="
        border
        rounded-sm
        border-gray-200
        focus:outline-none focus:border-indigo-500
        p-2
      "
      :class="{ 'bg-gray-200': disabled }"
    >
      <option disabled value="">{{ placeholder }}</option>
      <option v-for="(item, index) in items" :key="index" :value="item">
        {{ setItem(item) }}
      </option>
    </select>
  </div>
</template>

<script lang="ts">
interface itemInterface {
  name: String
}

function isObject(val: itemInterface) {
  return typeof val === 'object'
}

export default {
  name: 'SelectInput',

  props: {
    items: {
      required: true,
      type: [Array, Object, String],
    },
    label: {
      type: String,
      default: '',
    },
    placeholder: {
      type: String,
      default: 'Escolha uma opção',
    },
    disabled: {
      type: Boolean,
      default: false,
    },
    required: {
      type: Boolean,
      default: false,
    },
    value: {
      type: [Object, String, Number, Array],
      default: () => {},
    },
  },
  computed: {
    inputValue: {
      get() {
        return (this as any).value
      },
      set(value: any) {
        ;(this as any).$emit('input', value)
      },
    },
  },
  methods: {
    setItem(item: itemInterface) {
      const value = isObject(item) ? item.name : item
      return value
    },
  },
}
</script>
