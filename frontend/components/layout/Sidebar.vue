<template>
  <div>
    <nav class="w-full lg:hidden py-6 px-6 bg-red-200">
      <div class="flex items-center justify-between">
        <a class="text-xl text-white font-semibold" href="#">
          <h4 class="text-white uppercase">Caritas</h4>
        </a>
        <button
          class="navbar-burger flex items-center rounded focus:outline-none"
        >
          <burger-menu />
        </button>
      </div>
    </nav>
    <div class="hidden lg:block navbar-menu relative z-50 rounded-r-xl">
      <div
        class="navbar-backdrop fixed lg:hidden inset-0 bg-red-200 opacity-10"
      ></div>
      <nav
        class="
          h-screen
          left-0
          bottom-0
          flex flex-col
          lg:w-60
          pt-6
          pb-8
          bg-red-200
        "
      >
        <div class="px-4 pb-6">
          <h3 class="mb-2 text-xs uppercase text-gray-500 font-medium">
            Principais
          </h3>
          <ul class="mb-8 text-sm font-medium">
            <li>
              <nuxt-link
                class="
                  flex
                  items-center
                  pl-3
                  py-3
                  pr-4
                  text-gray-50
                  bg-red-500
                  rounded
                "
                to="/dashboard"
              >
                <CarClusterIcon class="inline-block mr-3" />
                <span>Dashboard</span>
              </nuxt-link>
            </li>
            <li>
              <nuxt-link
                class="
                  flex
                  items-center
                  pl-3
                  py-3
                  pr-2
                  text-gray-50
                  hover:bg-red-500
                  rounded
                "
                to="/partners"
              >
                <OpenBookIcon class="inline-block mr-3" />
                <span>Parceiros</span>
                <!--<span
                  class="
                    flex
                    justify-center
                    items-center
                    ml-auto
                    bg-indigo-500
                    w-6
                    h-6
                    text-xs
                    rounded-full
                  "
                  >4</span
                >-->
              </nuxt-link>
            </li>
            <li>
              <nuxt-link
                class="
                  flex
                  items-center
                  pl-3
                  py-3
                  pr-4
                  text-gray-50
                  hover:bg-red-500
                  rounded
                "
                to="/users"
              >
                <person-frame-icon class="inline-block mr-3" />
                <span>Funcionarios</span>
              </nuxt-link>
            </li>
            <li>
              <nuxt-link
                class="
                  flex
                  items-center
                  pl-3
                  py-3
                  pr-4
                  text-gray-50
                  hover:bg-red-500
                  rounded
                "
                to="/project"
              >
                <people-alt-icon
                  class="inline-block w-5 h-5 mr-3 text-gray-600 fill-current"
                />
                <span>Projectos</span>
              </nuxt-link>
            </li>
          </ul>
          <h3 class="mb-2 text-xs uppercase text-gray-500 font-medium">
            Secundários
          </h3>
          <!--<ul class="text-sm font-medium">
            <li>
              <nuxt-link
                class="
                  flex
                  items-center
                  pl-3
                  py-3
                  pr-4
                  text-gray-50
                  hover:bg-gray-900
                  rounded
                "
                to="/scheduling"
              >
                <scheduling class="inline-block mr-3" />
                <span>Agendamentos</span>
              </nuxt-link>
            </li>
            <li>
              <nuxt-link
                class="
                  flex
                  items-center
                  pl-3
                  py-3
                  pr-4
                  text-gray-50
                  hover:bg-gray-900
                  rounded
                "
                to="/archiv"
              >
                <archive-folder class="inline-block mr-3" />
                <span>Arquivos</span>
              </nuxt-link>
            </li>
          </ul>-->
          <div class="pt-8">
            <!--<div class="flex flex-col">
              <div
                class="
                  flex
                  items-center
                  pl-3
                  py-3
                  pr-2
                  text-gray-50
                  hover:bg-gray-900
                  rounded
                  cursor-pointer
                "
                @click="hiddenSettings = !hiddenSettings"
              >
                <configuration-icon class="inline-block mr-3" />
                <span class="select-none">Configurações</span>

                <span class="inline-block ml-auto">
                  <ArrowDownIcon
                    class="w-3 h-3 transform duration-500"
                    :class="{
                      'rotate-0': hiddenSettings,
                      'rotate-180': !hiddenSettings,
                    }"
                  />
                </span>
              </div>
              <ul
                class="pl-3 transition delay-300 duration-500 ease-in-out"
                :hidden="hiddenSettings"
              >
                <li @click="hiddenSettings = !hiddenSettings">
                  <nuxt-link
                    class="
                      flex
                      items-center
                      pl-5
                      py-1
                      pr-4
                      text-gray-50
                      hover:bg-gray-900
                      rounded
                    "
                    to="/settings/delegations"
                  >
                    <archive-folder class="inline-block mr-3" />
                    <span>Delegações</span>
                  </nuxt-link>
                </li>
                <li @click="hiddenSettings = !hiddenSettings">
                  <nuxt-link
                    class="
                      flex
                      items-center
                      pl-5
                      py-1
                      pr-4
                      text-gray-50
                      hover:bg-gray-900
                      rounded
                    "
                    to="/settings/finality"
                  >
                    <archive-folder class="inline-block mr-3" />
                    <span>Finalidades</span>
                  </nuxt-link>
                </li>
                <li @click="hiddenSettings = !hiddenSettings">
                  <nuxt-link
                    class="
                      flex
                      items-center
                      pl-5
                      py-1
                      pr-4
                      text-gray-50
                      hover:bg-gray-900
                      rounded
                    "
                    to="/settings/process-types"
                  >
                    <archive-folder class="inline-block mr-3" />
                    <span>Processos</span>
                  </nuxt-link>
                </li>
                <li @click="hiddenSettings = !hiddenSettings">
                  <nuxt-link
                    class="
                      flex
                      items-center
                      pl-5
                      py-1
                      pr-4
                      text-gray-50
                      hover:bg-gray-900
                      rounded
                    "
                    to="/settings/notifications"
                  >
                    <archive-folder class="inline-block mr-3" />
                    <span>Notificações</span>
                  </nuxt-link>
                </li>
              </ul>
            </div>-->
            <a
              class="
                flex
                items-center
                pl-3
                py-3
                pr-2
                text-gray-50
                hover:bg-red-500
                rounded
              "
              @click="handleLogout"
            >
              <exit-icon class="inline-block mr-3" />
              <span>Sair</span>
            </a>
          </div>
        </div>
      </nav>
    </div>
  </div>
</template>

<script lang="ts">
// import { defineComponent } from '@nuxtjs/composition-api'
// import BurgerMenu from '~/assets/icons/burger-menu.vue'
// import OpenBookIcon from '~/assets/icons/open-book.vue'
// import CarClusterIcon from '~/assets/icons/car-cluster.vue'
// import PersonFrameIcon from '~/assets/icons/person-frame.vue'
// import ArrowDownIcon from '~/assets/icons/arrow-down.vue'
// import PeopleAltIcon from '~/assets/icons/people-alt.vue'
// import ArchiveFolder from '~/assets/icons/archive-folder.vue'
// import ConfigurationIcon from '~/assets/icons/configurations.vue'
// import ExitIcon from '~/assets/icons/exit.vue'
// import Scheduling from '~/assets/icons/scheduling.vue'
// import Assignment from '~/assets/icons/assignment.vue'
// import Domain from '~/assets/icons/domain.vue'
// import ContactPhone from '~/assets/icons/contact-phone.vue'

// interface MenuItem {
//   icon: string
//   name: string
//   to: string | Object
//   counter?: number
//   subMenu: Array<MenuItem>
// }
// export default defineComponent({
//   name: 'Sidebar',
//   components: {
//     ExitIcon,
//     ArchiveFolder,
//     PeopleAltIcon,
//     ArrowDownIcon,
//     PersonFrameIcon,
//     CarClusterIcon,
//     OpenBookIcon,
//     BurgerMenu,
//     ConfigurationIcon,
//     Scheduling,
//     Domain,
//     Assignment,
//     ContactPhone,
//   },
//   data: () => ({
//     modules: [],
//     hiddenSettings: true,
//   }),
//   methods: {
//     handleLogout(action: any) {
//       action.preventDefault()
//       //this.$auth.logout()
//     },
//   },
// })
</script>
