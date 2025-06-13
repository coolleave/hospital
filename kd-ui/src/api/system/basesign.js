 
import request from '@/utils/request'

// 查询病例管理列表
export function listBasesign(query) {
  return request({
    url: '/system/basesign/list',
    method: 'get',
    params: query
  })
}

export function listBasesignAll(query) {
  return request({
    url: '/system/basesign/list',
    method: 'get',
    params: { ...query, needTotal: true } // 添加额外参数
  })
}

// 查询病例管理详细信息
export function getBasesign(id) {
  return request({
    url: '/system/basesign/' + id,
    method: 'get'
  })
}

// 新增病例管理
export function addBasesign(data) {
  return request({
    url: '/system/basesign',
    method: 'post',
    data: data
  })
}

// 修改病例管理
export function updateBasesign(data) {
  return request({
    url: '/system/basesign',
    method: 'put',
    data: data
  })
}

// 删除病例管理（支持单个或多个）
export function delBasesign(ids) {
  const idArray = Array.isArray(ids) ? ids : [ids];
  const idStr = encodeURIComponent(idArray.join(','));
  return request({
    url: '/system/basesign/' + idStr,
    method: 'delete'
  })
}