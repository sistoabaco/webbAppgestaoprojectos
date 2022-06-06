<template>
  <div class="flex flex-wrap w-full">
    <Modal
      :title="'Editar funcionario'"
      size="xl"
      @close="$router.push({ name: 'users' })"
    >
      <div class="grid grid-cols-3 gap-4 space-y-px w-max">
        <TextInput
          v-model="user.username"
          label="Username"
          placeholder="Username"
          class="col-span-3"
          required
        />
        <TextInput
          v-model="user.name"
          label="Nome"
          placeholder="Nome"
          class=""
          required
        />
        <TextInput
          v-model="user.email"
          label="Email"
          placeholder="Email"
          class=""
          required
        />
        <TextInput
          v-model="user.email"
          label="Telefone"
          placeholder="Email"
          class=""
          required
        />
        <TextInput
          v-model="user.email"
          label="Endereco"
          placeholder="Email"
          class=""
          required
        />
        <SelectInput
          v-model="user.role"
          label="Genero"
          placeholder=""
          :items="roleOptions"
          class=""
          required
        />
        <SelectInput
          v-model="user.role"
          label="Estado Civil"
          placeholder=""
          :items="roleOptions"
          class=""
          required
        />
        <SelectInput
          v-model="user.role"
          label="Categoria"
          placeholder=""
          :items="roleOptions"
          class=""
          required
        />
        <SelectInput
          v-model="user.department"
          label="Departamento"
          :items="departmentOptions"
          placeholder=""
          class=""
          required
        />
        <SelectInput
          v-model="user.department"
          label="Projecto"
          :items="departmentOptions"
          placeholder=""
          class=""
          required
        />
        <TextInput label="Senha" placeholder="Senha" class="" required />
        <TextInput
          label="Repetir senha"
          placeholder="Repetir senha"
          class=""
          required
        />
      </div>
      <template #actions>
        <div class="flex items-center space-x-4">
          <AppButton
            class="flex text-white w-full h-10"
            label="Salvar"
            variant="green"
            @click.native="handleSubmit"
          />
          <AppButton
            class="flex text-black"
            label="Cancelar"
            variant="white"
            size="large"
            @close="$router.push({ name: 'users' })"
          />
        </div>
      </template>
    </Modal>
  </div>
</template>

<script lang="ts">
import Modal from "~/components/common/misc/Modal.vue";
import AppButton from "~/components/common/misc/AppButton.vue";
import TextInput from "~/components/common/inputs/TextInput.vue";
import SelectInput from "~/components/common/inputs/SelectInput.vue";

export default {
  components: { Modal, AppButton, TextInput, SelectInput },
  asyncData({ params, redirect }) {
    if (!params.user) {
      redirect('/users')
    }
    const user = params.user
    return {
      user,
    }
  },

  data: () => ({
    roleOptions: [
      { value: "ADMIN", name: "Administrador" },
      { value: "MANAGER", name: "Gestor" },
      { value: "USER", name: "Utilizador" },
    ],
    departmentOptions: [
      { id: 1, value: "BAU_SEDE", name: "BAU (SEDE)" },
      { id: 2, value: "SLPS", name: "SLPS" },
      { id: 3, value: "BAU_MP", name: "BAU-MP" },
      { id: 4, value: "BAU_CM", name: "BAU-CM" },
      { id: 5, value: "ADMIN", name: "Admin" },
      { id: 6, value: "BAU_TESTE", name: "BAU-TESTE" },
    ],
  }),

  methods: {
    handleSubmit() {
    },
  },
};
</script>
