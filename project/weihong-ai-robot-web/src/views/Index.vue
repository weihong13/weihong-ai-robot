<template>
  <Layout>
    <!-- 主内容区域 -->
    <template #main-content>
      <div class="flex items-center justify-center flex-1">
        <div class="max-w-3xl w-full">
          <div class="text-center mb-10">
            <div class="flex items-center justify-center mb-3">
              <SvgIcon name="ai-robot-logo" customCss="w-10 h-10 text-gray-700 mr-3" />
              <h2 class="text-2xl text-gray-800">我是小宏 AI 机器人，很高兴见到你！</h2>
            </div>
            <p class="text-gray-500">我可以帮你写代码、写作各种创意内容，请把你的任务交给我吧~</p>
          </div>
          <div class="bg-gray-100 rounded-3xl px-4 py-3 mx-4 border border-gray-200 flex flex-col">
                  <textarea 
                    v-model="message" 
                    placeholder="给小宏 AI 机器人发送消息"
                    class="bg-transparent border-none outline-none w-full text-sm resize-none min-h-[24px]" 
                    rows="2"
                    ref="textareaRef"
                    >
                  </textarea>

                  <!-- 发送按钮 -->
                  <div class="flex justify-end mt-3">
                    <button 
                    class="flex items-center justify-center bg-[#4d6bfe] rounded-full w-8 h-8 border border-[#4d6bfe] hover:bg-[#3b5bef] transition-colors
                    disabled:opacity-50
                    disabled:cursor-not-allowed">
                        <SvgIcon name="up-arrow" customCss="w-5 h-5 text-white"></SvgIcon>
                    </button>
                  </div>
          </div>
        </div>
      </div>
    </template>
  </Layout>
</template>


<script setup>
import Layout from '@/layouts/Layout.vue'
import SvgIcon from '@/components/SvgIcon.vue'
</script>