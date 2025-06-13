import request from '@/utils/request'

// 查询心输出量监测列表
export function listPicco(query) {
  return request({
    url: '/system/picco/list',
    method: 'get',
    params: query
  })
}

// 查询心输出量监测详细
export function getPicco(Id) {
  return request({
    url: '/system/picco/' + Id,
    method: 'get'
  })
}

// 新增心输出量监测
export function addPicco(data) {
  return request({
    url: '/system/picco',
    method: 'post',
    data: data
  })
}

// 修改心输出量监测
export function updatePicco(data) {
  return request({
    url: '/system/picco',
    method: 'put',
    data: data
  })
}

// 删除心输出量监测
export function delPicco(Id) {
  return request({
    url: '/system/picco/' + Id,
    method: 'delete'
  })
}

export function listPiccoByEncounterId(encounterId) {
  return request({
    url: '/system/picco/list2',
    method: 'get',
    params: { encounterId }
  })
}