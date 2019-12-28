using Reduce.constant;
using Reduce.container;
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
    class UserImpl : AbstractImpl
    {

        public MsgEntity<String> login(String email, String password)
        {
            UserLoginReqVO vo = new UserLoginReqVO();
            vo.Email = email;
            vo.Password = password;
            String data = JsonHandle.toJson(vo);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Post(ReduceConstant.SERVER_PATH + "/user/login", data);

            MsgEntity<String> msg = JsonHandle.toBean<MsgEntity<String>>(httpResult.Body);
            if (msg.Code == 200)
            {
                ReduceContainer.token = msg.Datas.ToString();
            }
            return msg;
        }

        public MsgEntity<String> create(String email, String password, String code)
        {
            UserCreateReqVO vo = new UserCreateReqVO();
            vo.Email = email;
            vo.Password = password;
            vo.Code = code;
            String data = JsonHandle.toJson(vo);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Post(ReduceConstant.SERVER_PATH + "/user/create", data);

            MsgEntity<String> msg = JsonHandle.toBean<MsgEntity<String>>(httpResult.Body);
            if (msg.Code == 200)
            {
                ReduceContainer.token = msg.Datas.ToString();
            }
            return msg;
        }
    }
}
