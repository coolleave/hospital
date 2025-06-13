import request from '@/utils/request'

// 查询血氧分析列表
export function listGas(query) {
  return request({
    url: '/system/gas/list',
    method: 'get',
    params: query
  })
}

// 查询血氧分析详细
export function getGas(Id) {
  return request({
    url: '/system/gas/' + Id,
    method: 'get'
  })
}

// 新增血氧分析
export function addGas(data) {
  return request({
    url: '/system/gas',
    method: 'post',
    data: data
  })
}

// 修改血氧分析
export function updateGas(data) {
  return request({
    url: '/system/gas',
    method: 'put',
    data: data
  })
}

// 删除血氧分析
export function delGas(Id) {
  return request({
    url: '/system/gas/' + Id,
    method: 'delete'
  })
}
// 新增：根据 encounterId 查询生命体征
export function listGasByEncounterId(encounterId) {
  return request({
    url: '/system/gas/list2',
    method: 'get',
    params: { encounterId }
  })
}