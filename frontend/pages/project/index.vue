<template>
  <div>
    <page
      class="py-10 px-8"
      title="Projectos"
      sub-title="Lista de projectos existentes"
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
            :headers="projectHeaders"
            :items="projectItems"
            counter
            actions
          >
            <template #name="{ value: project }">
              <span class="flex font-semibold">{{ project.name }}</span>
            </template>
            <template #role="{ value: project }">
              <span>{{
                roleOptions.find((role) => role.value === project.role).name
              }}</span>
            </template>
            <template #actions="{ value: project }">
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
                  @click="goToEdit(project)"
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
                  @click="deleteProject(project)"
                >
                  <delete-outline />
                </div>
              </div>
            </template>
          </Table>
        </div>
      </div>
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
  },
  data: () => ({
    projectHeaders: [
      {
        key: "name",
        title: "Nome do Projecto",
        class: "whitespace-no-wrap",
      },
      {
        key: "implemetationSite",
        title: "Local de Implemetacao",
        class: "whitespace-no-wrap",
      },
      {
        key: "dateI",
        title: "Data de Inicio",
        class: "whitespace-no-wrap",
      },
      {
        key: "dateF",
        title: "Data Final",
        class: "whitespace-no-wrap",
      },
      {
        key: "money",
        title: "Orcamento",
        class: "whitespace-no-wrap",
      },
      {
        key: "status",
        title: "Estado",
        class: "whitespace-no-wrap",
      },
    ],
    projectItems: [
      {
        id: 1,
        username: "pmarques",
        name: "Construcao",
        implemetationSite: "Mecufi",
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
  methods: {
    goToEdit(project: any) {
      this.$router.push({
        name: "users-index-id-edit",
        params: { project: project },
      });
    },
    // deleteProjectr(project: any) {
    // },
    // handleSubmitDelete() {
    //   this.showDeleteModal = !this.showDeleteModal;
    // },
  },
});
</script>
