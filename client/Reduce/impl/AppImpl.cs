using Reduce.constant;
using Reduce.container;
using Reduce.exception;
using Reduce.handle;
using Reduce.impl.schema;
using Reduce.impl.vo;
using Reduce.impl.vo.msg;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Reduce.impl
{
    class AppImpl : AbstractImpl
    {

        public MsgEntity<List<AppInfo>> list()
        {
            Dictionary<String, String> headers = new Dictionary<string, string>();
            headers.Add("token", ReduceContainer.token);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Get(ReduceConstant.SERVER_PATH + "/app/list", ReduceContainer.encode, headers);

            MsgEntity<List<AppInfo>> msg = JsonHandle.toBean<MsgEntity<List<AppInfo>>>(httpResult.Body);

            return msg;
        }

        public MsgEntity<AppInfo> info(String appId)
        {
            Dictionary<String, String> headers = new Dictionary<string, string>();
            headers.Add("token", ReduceContainer.token);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Get(ReduceConstant.SERVER_PATH + "/app/info?id=" + appId, ReduceContainer.encode, headers);

            MsgEntity<AppInfo> msg = JsonHandle.toBean<MsgEntity<AppInfo>>(httpResult.Body);

            return msg;
        }

        public MsgEntity<String> save(AppInfo vo)
        {
            Dictionary<String, String> headers = new Dictionary<string, string>();
            headers.Add("token", ReduceContainer.token);
            String data = JsonHandle.toJson(vo);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Post(ReduceConstant.SERVER_PATH + "/app/save", data, ReduceContainer.encode, headers);

            MsgEntity<String> msg = JsonHandle.toBean<MsgEntity<String>>(httpResult.Body);

            return msg;
        }

        public MsgEntity<String> del(String appId)
        {
            Dictionary<String, String> headers = new Dictionary<string, string>();
            headers.Add("token", ReduceContainer.token);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Get(ReduceConstant.SERVER_PATH + "/app/del?id=" + appId, ReduceContainer.encode, headers);

            MsgEntity<String> msg = JsonHandle.toBean<MsgEntity<String>>(httpResult.Body);

            return msg;
        }
    }
}
