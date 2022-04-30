// index.ts

import { sayHello } from "../../api/hello"


Page({
  data: {
    message: 'Hello'
  },
  hi() {
      sayHello().then(data=>{
          const message = data + ''
          this.setData({
              message
          })
      })
  }
  })
