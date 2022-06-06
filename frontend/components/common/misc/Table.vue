<template>
  <div class="flex flex-col">
    <div class="my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
        <div
          class="
            shadow-sm
            overflow-hidden
            border-b border-gray-100
            sm:rounded-md
          "
        >
          <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
              <tr>
                <th v-if="counter" class="w-10">#</th>
                <th
                  v-for="(header, index) in setHeaders"
                  :key="index"
                  :class="header.class"
                  scope="col"
                  class="
                    text-left text-xs
                    font-medium
                    text-black
                    uppercase
                    py-4
                    tracking-wider
                  "
                >
                  {{ header.title }}
                </th>
              </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-100">
              <tr
                v-for="(item, index) in items"
                :key="index"
                class="hover:bg-gray-100 justify-center"
                @click="setActive(item)"
              >
                <td v-if="counter" class="w-10 pl-3">
                  {{ index + 1 }}
                </td>
                <td
                  v-for="key in setHeaders"
                  v-show="
                    getHeaderKey(key) !== 'id' &&
                    getHeaderKey(key) !== 'actions'
                  "
                  :key="getHeaderKey(key)"
                  class="py-4"
                >
                  <slot :name="getHeaderKey(key)" :value="item">
                    {{ item[getHeaderKey(key)] }}
                  </slot>
                </td>
                <td>
                  <slot v-if="actions" name="actions" :value="item" />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  props: {
    headers: {
      required: true,
      type: Array,
    },
    items: {
      type: Array,
      default: () => [],
    },
    value: {
      type: Object,
      default: () => {},
    },
    actions: {
      type: Boolean,
      default: false,
    },
    actionSize: {
      type: String,
      default: '',
    },
    counter: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    setHeaders(this: any) {
      return this.actions
        ? [
            ...this.headers,
            {
              key: 'actions',
              title: 'Ações',
              class: `whitespace-no-wrap ${this.actionSize}`,
            },
          ]
        : this.headers
    },
  },
  methods: {
    setActive(item: any) {
      this.$emit('clicked', item.id)
    },
    getHeaderKey: (column: any) =>
      typeof column === 'object' ? column.key : column,
  },
})
</script>
