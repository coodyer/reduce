using Reduce.constant;
using Reduce.exception;
using Reduce.handle;
using Reduce.impl.vo;
using Reduce.impl.vo.msg;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Reduce.impl
{
    class VerificatImpl : AbstractImpl
    {
        public MsgEntity<String> sendCode(String email)
        {
            SendCodeReqVO vo = new SendCodeReqVO();
            vo.Email = email;
            String data = JsonHandle.toJson(vo);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Post(ReduceConstant.SERVER_PATH + "/verificat/sendCode", data);

            MsgEntity<String> msg = JsonHandle.toBean<MsgEntity<String>>(httpResult.Body);
            return msg;
        }
    }
}
