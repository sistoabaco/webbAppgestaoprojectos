<template>
  <div>
    <page
      class="py-10 px-8"
      title="Funcionarios"
      sub-title="Lista de funcionarios"
    >
      <div class="flex flex-col space-y-6">
        <div class="flex flex-row space-x-2 justify-end">
          <TextInput label="" placeholder="Pesquisar" class="w-1/4 px-2" />
          <!--<div>
            <AppButton
              class="flex text-black"
              label="Imprimir"
              variant="white"
              icon
              size="large"
            >
              <template #icon>
                <print />
              </template>
            </AppButton>
          </div>
          <div>
            <AppButton
              class="flex text-white"
              label="Importar"
              variant="blue-400"
              icon
              size="large"
            >
              <template #icon>
                <AddUserIcon />
              </template>
            </AppButton>
          </div>-->
          <div>
            <AppButton
              class="flex text-white"
              label="Adicionar"
              variant="green"
              icon
              size="large"
              @click.native="
                $router.push({
                  name: 'users-index-create',
                })
              "
            >
              <template #icon>
                <AddUserIcon />
              </template>
            </AppButton>
          </div>
        </div>
        <div class="flex w-full">
          <Table
            class="w-full"
            :headers="usersHeaders"
            :items="users"
            counter
            actions
          >
            <template #name="{ value: user }">
              <span class="flex font-semibold">{{ user.name }}</span>
            </template>
            <template #role="{ value: user }">
              <span>{{
                roleOptions.find((role) => role.value === user.role).name
              }}</span>
            </template>
            <template #actions="{ value: user }">
              <div class="flex flex-wrap items-center space-x-2">
                <div
                  class="
                    flex
                    w-8
                    h-8
                    justify-items-center
                    p-2
                    rounded-sm
                    bg-yellow-500
                    text-white
                    cursor-pointer
                  "
                  @click="goToEdit(user)"
                >
                  <edit-outline />
                </div>
                <div
                  class="
                    flex
                    w-8
                    h-8
                    justify-items-center
                    p-2
                    rounded-sm
                    bg-red-500
                    text-white
                    cursor-pointer
                  "
                  @click="deleteUser(user)"
                >
                  <delete-outline />
                </div>
              </div>
            </template>
          </Table>
        </div>
        <div class="flex">
          <pagination
            :value="meta.currentPage + 1"
            :total-rows="meta.totalRows"
            :per-page="meta.perPage"
          />
        </div>
      </div>
      <form-user
        v-if="showModal"
        :selected-user="selectedUser"
        :mode="mode"
        @close="closeModal"
      />
      <remove-modal
        v-if="showDeleteModal"
        @close="showDeleteModal = false"
        @remove="handleSubmitDelete"
      >
        <div class="flex">
          <span
            >Tem certeza que pretende remover o utilizador:
            {{ selectedUser.name }}?</span
          >
        </div>
      </remove-modal>
      <nuxt-child />
    </page>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "@nuxtjs/composition-api";
import Page from "~/components/common/misc/Page.vue";
import AppButton from "~/components/common/misc/AppButton.vue";
import TextInput from "~/components/common/inputs/TextInput.vue";
import AddUserIcon from "~/assets/icons/add-user.vue";
import Table from "~/components/common/misc/Table.vue";
// import Pagination from '~/components/common/misc/Pagination.vue'
// import Print from '~/assets/icons/print.vue'
import EditOutline from "~/assets/icons/edit-outline.vue";
import DeleteOutline from "~/assets/icons/delete_outline.vue";
// import FormUser from '~/components/partials/users/FormUser.vue'
// import RemoveModal from '~/components/common/misc/RemoveModal.vue'
export default defineComponent({
  name: "Index",
  components: {
    Page,
    AppButton,
    TextInput,
    AddUserIcon,
    Table,
    EditOutline,
    DeleteOutline,
    // FormUser,
    // RemoveModal,
  },
  data: () => ({
    showModal: false,
    showDeleteModal: false,
    selectedUser: {},
    mode: "create",
    filters: {},
    usersHeaders: [
      {
        key: "name",
        title: "Nome Completo",
        class: "whitespace-no-wrap",
      },
      {
        key: "email",
        title: "Email",
        class: "whitespace-no-wrap",
      },
      {
        key: "department",
        title: "Departamento",
        class: "whitespace-no-wrap",
      },
      {
        key: "role",
        title: "Roles",
        class: "whitespace-no-wrap",
      },
    ],
    userItems: [
      {
        id: 1,
        username: "pmarques",
        name: "Patricio Marques",
        email: "patricio.marques@unilurio.ac.mz",
        department: "Recursos humano",
        role: "ADMIN",
      },
      {
        id: 2,
        username: "sabaco",
        name: "Sisto Abaco",
        email: "sabaco@unilurio.ac.mz",
        department: "Logistica",
        role: "MANAGER",
      },
    ],
    roleOptions: [
      { value: "ADMIN", name: "Administrador" },
      { value: "MANAGER", name: "Gestor" },
      { value: "USER", name: "Utilizador" },
    ],
  }),
  computed: {
    meta() {
      // pagination payload here
      const meta = {
        currentPage: 0,
        totalRows: 14,
        perPage: 10,
        isLast: false,
      };
      return meta;
    },
    users(){
      return this.$store.state.users.data
    }
  },
  async fetch(){
    this.$store.commit("users/storeData",
      ((await this.$axios.get("http://localhost:8080/users/listaFuncionario")).data
      )

    )
  },
  methods: {
    // openModal() {
    //   this.showModal = !this.showModal
    // },
    closeModal(this: any) {
      this.showModal = !this.showModal;
      this.mode = "create";
      this.$nuxt.refresh();
    },
    goToEdit(user: any) {
      this.$router.push({
        name: "users-index-id-edit",
        params: { user: user },
      });
      console.log(user)
    },
    deleteUser(user: any) {
      this.selectedUser = user || {};
      this.showDeleteModal = !this.showDeleteModal;
    },
    handleSubmitDelete() {
      this.showDeleteModal = !this.showDeleteModal;
    },
  },
});
</script>
