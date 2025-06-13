import request from '@/utils/request'

// 查询体外膜肺氧合列表
export function listEcmo(query) {
  return request({
    url: '/system/ecmo/list',
    method: 'get',
    params: query
  })
}

// 查询体外膜肺氧合详细
export function getEcmo(Id) {
  return request({
    url: '/system/ecmo/' + Id,
    method: 'get'
  })
}

// 新增体外膜肺氧合
export function addEcmo(data) {
  return request({
    url: '/system/ecmo',
    method: 'post',
    data: data
  })
}

// 修改体外膜肺氧合
export function updateEcmo(data) {
  return request({
    url: '/system/ecmo',
    method: 'put',
    data: data
  })
}

// 删除体外膜肺氧合
export function delEcmo(Id) {
  return request({
    url: '/system/ecmo/' + Id,
    method: 'delete'
  })
}
export function listEcmoByEncounterId(encounterId) {
  return request({
    url: '/system/ecmo/list2',
    method: 'get',
    params: { encounterId }
  })
}