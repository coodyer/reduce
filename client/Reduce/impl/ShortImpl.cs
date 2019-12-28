using Reduce.constant;
using Reduce.container;
using Reduce.exception;
using Reduce.handle;
using Reduce.impl.container;
using Reduce.impl.schema;
using Reduce.impl.vo;
using Reduce.impl.vo.msg;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Reduce.impl
{
    class ShortImpl : AbstractImpl
    {

        public MsgEntity<PagerContainer<ShortInfo>> pager()
        {
            Dictionary<String, String> headers = new Dictionary<string, string>();
            headers.Add("token", ReduceContainer.token);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Get(ReduceConstant.SERVER_PATH + "/short/page", ReduceContainer.encode, headers);

            MsgEntity<PagerContainer<ShortInfo>> msg = JsonHandle.toBean<MsgEntity<PagerContainer<ShortInfo>>>(httpResult.Body);

            return msg;
        }

        public MsgEntity<String> create(String unionId, String url)
        {
            Dictionary<String, String> headers = new Dictionary<string, string>();
            headers.Add("token", ReduceContainer.token);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Get(ReduceConstant.SERVER_PATH + "/short/create?unionId=" + unionId + "&url=" + url, ReduceContainer.encode, headers);

            MsgEntity<String> msg = JsonHandle.toBean<MsgEntity<String>>(httpResult.Body);

            return msg;
        }


        public MsgEntity<String> del(long shortId)
        {
            Dictionary<String, String> headers = new Dictionary<string, string>();
            headers.Add("token", ReduceContainer.token);
            Reduce.handle.HttpHandle.HttpResult httpResult = Http.Get(ReduceConstant.SERVER_PATH + "/short/del?id=" + Convert.ToString(shortId), ReduceContainer.encode, headers);

            MsgEntity<String> msg = JsonHandle.toBean<MsgEntity<String>>(httpResult.Body);

            return msg;
        }
    }
}
